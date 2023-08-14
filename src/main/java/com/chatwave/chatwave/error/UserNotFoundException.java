package com.chatwave.chatwave.error;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(Long id) {
        super();
    }

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super();
    }

}
