package com.example.resume_builder.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkExp {
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

        @JsonProperty("WE_title")
        private String WE_title;
        @JsonProperty("WE_company")
        private String WE_company;
        @JsonProperty("WE_tenure")
        private String WE_tenure;
        @JsonProperty("WE_description")
        private String WE_description;


    }
