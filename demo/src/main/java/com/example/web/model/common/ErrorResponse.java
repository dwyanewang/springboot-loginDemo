package com.example.web.model.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorResponse extends JsonResponse {
    private List<ErrorDetail> errors = new ArrayList<ErrorDetail>();

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setObjectErrors(List<ObjectError> errors) {
        for (ObjectError error : errors) {
            if (FieldError.class.isAssignableFrom(error.getClass())) {
                FieldError err = (FieldError) error;
                ErrorDetail e = new ErrorDetail();
                e.setCode(err.getCode());
                e.setField(err.getField());
                e.setMessage(err.getDefaultMessage());
                this.errors.add(e);
            }
        }
    }
    
    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }
    
    public void addError(ErrorDetail error){
        errors.add(error);
    }
    
}
