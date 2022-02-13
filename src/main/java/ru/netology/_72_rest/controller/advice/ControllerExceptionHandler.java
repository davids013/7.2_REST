package ru.netology._72_rest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology._72_rest.exception.InvalidCredentials;
import ru.netology._72_rest.exception.UnauthorizedUser;

import javax.validation.ValidationException;

@RestControllerAdvice("ru.netology._72_rest.controller")
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String runtimeExHandler(Exception e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "{\"Status\":" + HttpStatus.INTERNAL_SERVER_ERROR.value() +
                ",\"Exception\":\"" + e.getMessage() + "\"}";
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthUserExHandler(UnauthorizedUser e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "{\"Status\":" + HttpStatus.UNAUTHORIZED.value() +
                ",\"UnauthorizedUserException\":\"" + e.getMessage() + "\"}";
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invCredExHandler(InvalidCredentials e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "{\"Status\":" + HttpStatus.BAD_REQUEST.value() +
                ",\"InvalidCredentialsException\":\"" + e.getMessage() + "\"}";
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String constViolExHandler(ValidationException e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "{\"Status\":" + HttpStatus.BAD_REQUEST.value() +
                ",\"ValidationException\":\"" + e.getMessage() + "\"}";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String metArgNotValidExHandler(MethodArgumentNotValidException e) {
        final String message = e.getMessage();
        final String target = "default message [";
        System.err.println(e.getClass() + ": " + message);
        final int index = message.lastIndexOf(target) + target.length();
        return "{\"Status\":" + HttpStatus.BAD_REQUEST.value() +
                ",\"MethodArgumentNotValidException\":\"" + message.substring(index, message.length() - 3) + "\"}";
    }
}
