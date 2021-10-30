package com.tmoreno.kata.passwordvalidator;

public final class PasswordValidator {

    public void validate(String password) {
        if (password.length() <= 8) {
            throw new InvalidLengthException();
        }
    }
}
