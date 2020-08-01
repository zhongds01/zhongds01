package com.example.springboot.exception;

import com.example.springboot.constant.DConstant;
import com.example.springboot.controller.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2020/7/31 0:27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 使用@requestBody注解参数校验异常捕获处理
     *
     * @param e MethodArgumentNotValidException异常对象
     * @return 响应结果
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("", e);


        CommonResponse response = new CommonResponse();
        BindingResult bindingResult = e.getBindingResult();

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();

            logger.error("the error message is " + defaultMessage);

            response.setCode(DConstant.HttpConstant.VALIDATE_ERROR);
            response.setDesc(defaultMessage);

        }

        return response;
    }

    /**
     * 参数校验异常捕获处理
     *
     * @param e 参数校验异常对象
     * @return 响应结果
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public CommonResponse handleBindException(BindException e) {
        logger.error("", e);
        CommonResponse response = new CommonResponse();

        if (e.getBindingResult().hasErrors()) {
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            String defaultMessage = fieldErrors.get(0).getDefaultMessage();
            logger.error("the error message is:" + defaultMessage);
            response.setCode(DConstant.HttpConstant.VALIDATE_ERROR);
            response.setDesc(defaultMessage);
        }

        return response;
    }

    /**
     * 使用@requestParm注解参数校验异常捕获处理
     *
     * @param e ConstraintViolationException异常对象
     * @return 响应结果
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public CommonResponse handleConstraintViolationException(ConstraintViolationException e) {
        logger.error("", e);
        CommonResponse response = new CommonResponse();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        for (ConstraintViolation<?> next : constraintViolations) {
            String message = next.getMessage();
            response.setCode(DConstant.HttpConstant.VALIDATE_ERROR);
            response.setDesc(message);
            break;
        }

        return response;
    }

    /**
     * 处理其他异常
     *
     * @param e 异常对象
     * @return 响应结果
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e) {
        CommonResponse response = new CommonResponse();
        return response;
    }
}
