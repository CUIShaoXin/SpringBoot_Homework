package com.itxg.handler;

import com.itxg.exception.EmpNotFoundException;
import com.itxg.exception.ParamInvalidException;
import com.itxg.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamInvalidException.class)
    public Result handleParamInvalidException(ParamInvalidException e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(EmpNotFoundException.class)
    public Result handleEmpNotFoundException(EmpNotFoundException e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error("系统异常，请联系管理员");
    }
}