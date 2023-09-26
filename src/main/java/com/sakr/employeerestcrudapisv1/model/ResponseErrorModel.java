package com.sakr.employeerestcrudapisv1.model;

import lombok.Data;

@Data
public class ResponseErrorModel {

    private int status;
    private String message;
    private long timeStamp;


    public ResponseErrorModel(){

    }

    public ResponseErrorModel(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
