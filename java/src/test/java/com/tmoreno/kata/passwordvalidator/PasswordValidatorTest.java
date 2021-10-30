package com.tmoreno.kata.passwordvalidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

	@Test
	public void should_throw_invalid_length_exception_when_password_length_is_less_than_8_chars() {
		assertThrows(InvalidLengthException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("1234567");
		});
	}

	@Test
	public void should_throw_invalid_length_exception_when_password_length_is_8_chars() {
		assertThrows(InvalidLengthException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("12345678");
		});
	}

	@Test
	public void should_valid_password_when_password_length_is_more_than_8_chars_and_contains_a_capital_letter() {
		PasswordValidator passwordValidator = new PasswordValidator();
		passwordValidator.validate("12345678A");
	}

	@Test
	public void should_throw_no_capital_letters_exception_when_password_has_no_capital_letters() {
		assertThrows(NoCapitalLettersException.class, () -> {
			PasswordValidator passwordValidator = new PasswordValidator();
			passwordValidator.validate("123456789");
		});
	}
}
