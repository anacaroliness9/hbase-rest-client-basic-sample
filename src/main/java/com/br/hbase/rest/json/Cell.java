
package com.br.hbase.rest.json;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "column", "timestamp", "resultado" })
public class Cell {

	@JsonProperty("column")
	private String column;
	@JsonProperty("timestamp")
	private Timestamp timestamp;
	@JsonProperty("$")
	private String resultado;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("column")
	public String getColumn() {
		return column;
	}

	@JsonProperty("column")
	public void setColumn(String column) {
		this.column = column;
	}

	@JsonProperty("timestamp")
	public Timestamp getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("$")
	public String getResultado() {
		return resultado;
	}

	@JsonProperty("$")
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}