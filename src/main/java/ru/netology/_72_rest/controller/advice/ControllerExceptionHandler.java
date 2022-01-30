package ru.netology._72_rest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology._72_rest.exception.InvalidCredentials;
import ru.netology._72_rest.exception.UnauthorizedUser;

@RestControllerAdvice("ru.netology._72_rest.controller")
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String runtimeExHandler(Exception e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "Status: " + HttpStatus.INTERNAL_SERVER_ERROR + "\t\r\nException: " + e.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthUserExHandler(UnauthorizedUser e) {
        System.err.println(e.getClass() + ": " + e.getMessage());
        return "Status: " + HttpStatus.UNAUTHORIZED + "\t\r\nUnauthorizedUserException: " + e.getMessage();
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invCredExHandler(InvalidCredentials e) {
        return "Status: " + HttpStatus.BAD_REQUEST + "\t\r\nInvalidCredentialsException: " + e.getMessage();
    }
}
