package ru.netology.exeptions;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String message) {
        super(message);
    }
}
