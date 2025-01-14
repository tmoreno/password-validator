package com.tmoreno.kata.passwordvalidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

	@Test
	public void should_valid_password_when_password_length_is_more_than_8_chars_and_contains_a_capital_letter_and_contains_a_lower_letter_and_contains_numbers_and_contains_underscores() {
		PasswordValidator passwordValidator = new PasswordValidator();
		passwordValidator.validate("12345678Ab_");
	}

	@Test
	public void should_throw_invalid_length_exception_when_password_length_is_less_than_8_chars() {
		assertThrows(InvalidLengthException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("Ab_1234");
		});
	}

	@Test
	public void should_throw_invalid_length_exception_when_password_length_is_8_chars() {
		assertThrows(InvalidLengthException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("Ab_12345");
		});
	}

	@Test
	public void should_throw_no_capital_letters_exception_when_password_has_no_capital_letters() {
		assertThrows(NoCapitalLettersException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("ab_123456");
		});
	}

	@Test
	public void should_throw_no_lower_letters_exception_when_password_has_no_lower_letters() {
		assertThrows(NoLowerLettersException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("AB_123456");
		});
	}

	@Test
	public void should_throw_no_numbers_exception_when_password_has_no_numbers() {
		assertThrows(NoNumbersException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("Ab_******");
		});
	}

	@Test
	public void should_throw_no_underscore_exception_when_password_has_no_underscores() {
		assertThrows(NoUnderscoreException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("Ab*123456");
		});
	}
}
