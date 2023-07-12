package com.resume.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Achievement {
	
	@JsonProperty("field")
    private String field;
	
	@JsonProperty("awards")
    private String awards;

	public Achievement(String field, String awards) {
		super();
		this.field = field;
		this.awards = awards;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}
	@Override
	public String toString() {
		    String ans = "{";
	        ans += "\"Type\": " + "\"" + this.field + "\", ";
	        ans += "\"Description\": " + "\"" + this.awards + "\"}";
	        return ans;
	    }
	}