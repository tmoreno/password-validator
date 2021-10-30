package com.tmoreno.kata.passwordvalidator;

public final class PasswordValidator {

    public void validate(String password) {
        containsAnUnderscore(password);

        haveMoreThan8Chars(password);

        containsACapitalLetter(password);

        containsALowerLetter(password);

        containsANumber(password);
    }

    private void haveMoreThan8Chars(String password) {
        if (password.length() <= 8) {
            throw new InvalidLengthException();
        }
    }

    private void containsACapitalLetter(String password) {
        if (password.equals(password.toLowerCase())) {
            throw new NoCapitalLettersException();
        }
    }

    private void containsALowerLetter(String password) {
        if (password.equals(password.toUpperCase())) {
            throw new NoLowerLettersException();
        }
    }

    private void containsANumber(String password) {
        if (!password.matches(".*\\d.*")) {
            throw new NoNumbersException();
        }
    }

    private void containsAnUnderscore(String password) {
        if (!password.contains("_")) {
            throw new NoUnderscoreException();
        }
    }
}
