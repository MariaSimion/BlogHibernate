package com.maria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by msimion on 9/1/2015.
 */

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }


}
