package com.example.resume_builder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResumeData {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    private String name;
    private String title;
    private String description;
    private String email;
    private String phone;
    private String location;
    private String link1;
    private String link2;

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<WorkExp> getWorkExps() {
        return WorkExps;
    }

    public void setWorkExps(List<WorkExp> workExps) {
        WorkExps = workExps;
    }

    public List<Education> getEducations() {
        return Educations;
    }

    public void setEducations(List<Education> educations) {
        Educations = educations;
    }

    @JsonProperty("skills")
    private List<String> skills;
    @JsonProperty("WorkExps")
    private List<WorkExp> WorkExps;
    @JsonProperty("Educations")
    private List<Education> Educations;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @JsonProperty("projects")
    private List<Project> projects;
}

class WorkExp {
    public String getWE_title() {
        return WE_title;
    }

    public void setWE_title(String WE_title) {
        this.WE_title = WE_title;
    }

    public String getWE_company() {
        return WE_company;
    }

    public void setWE_company(String WE_company) {
        this.WE_company = WE_company;
    }

    public String getWE_tenure() {
        return WE_tenure;
    }

    public void setWE_tenure(String WE_tenure) {
        this.WE_tenure = WE_tenure;
    }

    public String getWE_description() {
        return WE_description;
    }

    public void setWE_description(String WE_description) {
        this.WE_description = WE_description;
    }

    private String WE_title;
    private String WE_company;
    private String WE_tenure;
    private String WE_description;


}

class Education {
    private String deg_name;
    private String college_name;
    private String period;

    public String getDeg_name() {
        return deg_name;
    }

    public void setDeg_name(String deg_name) {
        this.deg_name = deg_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}

class Project{
    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String proj_name;
    private String tools;
    private String description;
}
