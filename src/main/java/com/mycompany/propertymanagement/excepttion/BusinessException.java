package com.mycompany.propertymanagement.excepttion;

import org.aspectj.apache.bcel.classfile.annotation.RuntimeTypeAnnos;

import java.util.List;

public class BusinessException extends RuntimeException {
    private List<ErrorModel> errors;

    public BusinessException(){

    }
    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }
    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }

}
