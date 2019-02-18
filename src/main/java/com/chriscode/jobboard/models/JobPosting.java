package com.chriscode.jobboard.models;

public class JobPosting {

    private String jobTitle;
    private int jobReq;
    private String jobDescription;
    private String jobCompany;

    public jobPosting(){}

    public jobPosting(String jobTitle, String jobDescription, String jobCompany, int jobReq){
        this.jobTitle= jobTitle;
        this.jobDescription=jobDescription;
        this.jobCompany= jobCompany;
        this.jobReq=jobReq;
    }


}
