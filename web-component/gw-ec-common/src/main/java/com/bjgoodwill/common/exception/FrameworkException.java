package com.bjgoodwill.common.exception;


/**
 * 作者：Frank
 * 版本：1.0
 */
public class FrameworkException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FrameworkException() {
        super();
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(Throwable cause) {
        super(cause);
    }
}
