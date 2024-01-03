package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {

    // Oluşturulan validasyonlarda herhangi bir hata olursa geriye global halde bad request cevabını gönderecektir.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNot(MethodArgumentNotValidException ex ) {
        return new ResponseEntity(ex.getFieldErrors(), HttpStatus.BAD_REQUEST);
    }

}
