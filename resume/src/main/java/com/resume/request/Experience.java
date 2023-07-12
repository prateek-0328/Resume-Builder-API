package com.resume.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Experience {
    @JsonProperty("company_name")
    private String company_name;

    @JsonProperty("passing_year")
    private String passing_year;
    
    @JsonProperty("responsibilities")
    private String responsibilities;

	public Experience(String companyName, String passingYear, String responsibilities) {
		super();
		this.company_name = companyName;
		this.passing_year = passingYear;
		this.responsibilities = responsibilities;
	}

	public String getCompanyName() {
		return company_name;
	}

	public void setCompanyName(String companyName) {
		this.company_name = companyName;
	}

	public String getPassingYear() {
		return passing_year;
	}

	public void setPassingYear(String passingYear) {
		this.passing_year = passingYear;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	
	@Override
	public String toString() {
		String ans = "{";
        ans += "\"CompanyName\": " + "\"" + this.company_name+ "\", ";
        ans += "\"Year\": " + "\"" + this.passing_year+ "\", ";
        ans += "\"Description\": " + "\"" + this.responsibilities + "\"}";

        return ans;
	}
}

