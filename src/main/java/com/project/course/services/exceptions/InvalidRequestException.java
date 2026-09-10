package com.project.course.services.exceptions;

public class InvalidRequestException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidRequestException(String msg){
        super(msg);
    }
}
