package com.example.springbootapidemo.controller;

import com.example.springbootapidemo.exception.DataNotFoundexception;
import com.example.springbootapidemo.model.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DataNotFoundexception.class)
    public ResponseEntity handleDataNotFound(DataNotFoundexception exception) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(exception.getMessage());
        messageInfo.setCode("10001");

        return  new ResponseEntity(messageInfo, HttpStatus.NOT_FOUND);
    }
}
