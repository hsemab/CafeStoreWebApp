package com.patika.cafestorewebapp.Core.Results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult() {
        super(true);
    }

    public SuccessDataResult( String message) {
        super(true, message);
    }

    public SuccessDataResult( T data, String message) {
        super(true, data, message);
    }

    public SuccessDataResult( T data) {
        super(true, data);
    }
}