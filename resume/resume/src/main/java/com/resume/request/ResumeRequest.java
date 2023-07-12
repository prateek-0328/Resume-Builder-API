package com.resume.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResumeRequest {
	@JsonProperty("template_id")
    private String template_id;
	
	@JsonProperty("personal_information")
    private PersonalInformation personal_information;

    @JsonProperty("job_title")
    private String job_title;

    @JsonProperty("career_objective")
    private String career_objective;

    @JsonProperty("skills")
    private List<String> skills;

    @JsonProperty("education")
    private List<Education> education;

    @JsonProperty("experience")
    private List<Experience> experience;

    @JsonProperty("achievements")
    private List<Achievement> achievements;

    public ResumeRequest(String template_id, PersonalInformation personalInformation, String jobTitle,
			String careerObjective, List<String> skills, List<Education> education, List<Experience> experience,
			List<Achievement> achievements) {
		super();
		this.template_id = template_id;
		this.personal_information = personalInformation;
		this.job_title = jobTitle;
		this.career_objective = careerObjective;
		this.skills = skills;
		this.education = education;
		this.experience = experience;
		this.achievements = achievements;
	}


    public String getTemplate_id() {
        return template_id;
    }
    @Override
    public String toString() {
    	String ans="{";
    	ans+= personal_information;
    	ans+= "\"JobTitle\" : " + "\"" + this.job_title + "\", " ;
    	ans+= "\"Summary\" : " + "\"" + this.career_objective + "\", " ;
    	ans+="\"Skills\" : " +"[ ";
    	for (int i =0; i<skills.size()-1; i++){
            ans+="\"" + skills.get(i) + "\",";
        }
    	ans+= "\"" + skills.get(skills.size()-1) + "\"]";
    	ans+= ", \"Education\" : "  + this.education + ", " ;
    	ans+= "\"Experience\" : " +  this.experience + ", " ;
    	ans+= "\"Achievements\" : " + this.achievements + " } " ;
    	return ans;
    	
    }
}
