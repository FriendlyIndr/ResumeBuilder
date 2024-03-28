package com.example.resume_builder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Education {
    @JsonProperty("deg_name")
    private String deg_name;
    @JsonProperty("college_name")
    private String college_name;
    @JsonProperty("period")
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
