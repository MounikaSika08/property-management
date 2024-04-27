package com.mycompany.propertymanagement.excepttion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handlerFieldValidation(MethodArgumentNotValidException ex){
        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel=null;
        List<FieldError> list = ex.getBindingResult().getFieldErrors();
        for(FieldError error:list){
            logger.info("Inside Field Validation: {} {}", error.getField(), error.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(error.getField());
            errorModel.setMessage(error.getDefaultMessage());
            errorModels.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModels, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        System.out.println("Business exception is thrown");
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
