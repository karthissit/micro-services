package com.demo.userservice.advise;

import com.demo.userservice.exceptions.UserDataIntegrityVoilation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionAdvise {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserDataIntegrityVoilation.class)
    public ResponseEntity<String> hadUserInfoConflict(){


        return new ResponseEntity<>("Your data had a conflict!", HttpStatus.CONFLICT);
    }
}
