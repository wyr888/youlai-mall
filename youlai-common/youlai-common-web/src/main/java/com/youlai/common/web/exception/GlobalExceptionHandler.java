package com.youlai.common.web.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youlai.common.result.Result;
import com.youlai.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局系统异常处理
 *
 * @author hxrui
 * @date 2020-02-25 13:54
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Result handleIllegalArgumentException(IllegalArgumentException e) {
        return Result.error(e.getMessage());
    }


    @ExceptionHandler(JsonProcessingException.class)
    public Result handleJsonProcessingException(JsonProcessingException e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        if (e.getResultCode() != null) {
            return Result.custom(e.getResultCode());
        }
        return Result.error(e.getMessage());
    }

  /*  @ExceptionHandler(InvalidGrantException.class)
    public Result handleInvalidGrantException(InvalidGrantException e){
        return Result.custom(ResultCodeEnum.USER_LOGIN_ERROR);
    }*/
}
