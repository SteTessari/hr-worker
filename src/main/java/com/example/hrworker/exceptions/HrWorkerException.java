package com.example.hrworker.exceptions;


import org.springframework.http.HttpStatus;

public class HrWorkerException extends RuntimeException{
    private final String mensagem;
    private final HttpStatus httpStatus;

    public HrWorkerException(HttpStatus httpStatus, String mensagem) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
    }

    public String getMensagem() {
        return mensagem;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
