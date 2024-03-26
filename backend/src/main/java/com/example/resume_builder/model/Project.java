package com.example.resume_builder.model;

public class Project {
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
