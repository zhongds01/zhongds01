package com.example.springboot.exception;

/**
 * Description: 自定义异常类
 * Author: zhongds
 * Date : 2020/8/2 15:42
 */
public class DException extends Exception {

    private static final long serialVersionUID = -1667217529383687983L;

    public DException() {
        super();
    }

    public DException(String message) {
        super(message);
    }

    public DException(String message, Throwable cause) {
        super(message, cause);
    }

    public DException(Throwable cause) {
        super(cause);
    }

    protected DException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
