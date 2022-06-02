package com.star.exceptions;

/**
 * 自定义异常
 *
 * @author star
 */
public class IllegalTokenException extends RuntimeException {

    public IllegalTokenException(String message) {
        super(message);
    }
}
