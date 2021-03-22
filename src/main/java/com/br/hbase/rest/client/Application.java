package com.br.hbase.rest.client;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.kerberos.client.KerberosRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.br.hbase.rest.json.Registry;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String url = "http://lab:20550/tb_hbase_hashs/10.10.10.10/norte:hash";
			KerberosRestTemplate restTemplat = new KerberosRestTemplate("/root/hbase-api.keytab",
					"hbase/api@CLOUDERA");
			Registry registro = restTemplat.getForObject(url, Registry.class);
			System.out.println("API Result: ");
			System.out.println(registro.toString());

			// Decode
			String resultado = registro.getRow().get(0).getCell().get(0).getResultado();
			byte[] asBytes = Base64.getDecoder().decode(resultado);
			System.out.println("Registry Result: ");
			System.out.println(new String(asBytes, "utf-8"));
		};
	}
}