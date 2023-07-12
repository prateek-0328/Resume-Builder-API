package com.resume.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Education {
    @JsonProperty("school_name")
    private String school_name;

    @JsonProperty("passing_year")
    private String passing_year;
    
    @JsonProperty("description")
    private String description;

	public Education(String schoolName, String passingYear, String description) {
		super();
		this.school_name = schoolName;
		this.passing_year = passingYear;
		this.description = description;
	}

	public String getSchoolName() {
		return school_name;
	}

	public void setSchoolName(String schoolName) {
		this.school_name = schoolName;
	}

	public String getPassingYear() {
		return passing_year;
	}

	public void setPassingYear(String passingYear) {
		this.passing_year = passingYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
	        String ans = "{";
	        ans += "\"SchoolName\": " + "\""+ this.school_name + "\", ";
	        ans += "\"Year\": " + "\"" + this.passing_year + "\", ";
	        ans += "\"Description\": " + "\"" + this.description + "\" }";
	        return ans;
	    }
	}
    

