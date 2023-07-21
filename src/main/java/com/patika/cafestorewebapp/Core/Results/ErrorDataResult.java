package com.patika.cafestorewebapp.Core.Results;

public class ErrorDataResult<X> extends DataResult<X>{
    public ErrorDataResult() {
        super(false);
    }
    public ErrorDataResult( String message) {
        super(false, message);
    }

    public ErrorDataResult( X data, String message) {
        super(false, data, message);
    }

    public ErrorDataResult( X data) {
        super(false, data);
    }
}
