package com.jcohy.study.security.exception;

/**
 * created by Wuwenbin on 2017/8/19 at 21:20
 */
public class EncryptException extends RuntimeException {

    public EncryptException() {
        super();
    }

    public EncryptException(String message) {
        super(message);
    }

    public EncryptException(Throwable cause) {
        super(cause);
    }

    public EncryptException(String message, Throwable cause) {
        super(message, cause);
    }
}
