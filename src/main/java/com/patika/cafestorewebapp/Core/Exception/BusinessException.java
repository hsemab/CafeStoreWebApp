package com.patika.cafestorewebapp.Core.Exception;

import com.patika.cafestorewebapp.Service.Contrats.BaseService;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
