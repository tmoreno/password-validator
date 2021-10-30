package com.tmoreno.kata.passwordvalidator;

public final class PasswordValidator {

    public void validate(String password) {
        if (password.length() <= 8) {
            throw new InvalidLengthException();
        }

        if (password.equals(password.toLowerCase())) {
            throw new NoCapitalLettersException();
        }

        if (password.equals(password.toUpperCase())) {
            throw new NoLowerLettersException();
        }

        if (!password.matches(".*\\d.*")) {
            throw new NoNumbersException();
        }
    }
}
