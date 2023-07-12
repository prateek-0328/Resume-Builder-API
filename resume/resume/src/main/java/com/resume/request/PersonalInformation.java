package com.resume.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalInformation {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("last_name")
    private String last_name;
	
	@JsonProperty("email_address")
    private String email_address;
	
	@JsonProperty("phone_number")
    private String phone_number;
	
	@JsonProperty("linkedin_url")
    private String linkedin_url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getLinkedin_url() {
		return linkedin_url;
	}
	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	public PersonalInformation(String name, String last_name, String email_address, String phone_number,
			String linkedin_url) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email_address = email_address;
		this.phone_number = phone_number;
		this.linkedin_url = linkedin_url;
	}
    @Override
	public String toString() {
    	    String ans = "";
            ans += "\"Name\" : " + "\"" + this.name + "\", " ;
            ans += "\"LastName\" : " + "\"" + this.last_name + "\", ";
            ans += "\"EmailAddress\" : "+ "\"" + this.email_address + "\", ";
            ans += "\"PhoneNumber\" : " + "\"" + this.phone_number + "\", ";
            String url_format = "\"<a href=\\\"" + this.linkedin_url + "\\\">linkedIn</a>\", ";
            ans += "\"LinkedIn\" : " + url_format;
            return ans;
        }
	}
