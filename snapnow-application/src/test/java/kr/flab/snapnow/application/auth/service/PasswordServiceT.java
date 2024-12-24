package kr.flab.snapnow.application.auth.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import kr.flab.snapnow.domain.auth.exception.InvalidPasswordException;
import kr.flab.snapnow.domain.user.model.userAccount.credential.Email;
import kr.flab.snapnow.domain.user.model.userAccount.credential.EmailCredential;

public class PasswordServiceT {

    private PasswordService passwordService = new PasswordService();


    @Test
    void validateAndEncodePassword() {
        //given
        String password = "abcd1234";

        //when
        String encodedPassword = passwordService.validateAndEncodePassword(password);

        //then
        assertTrue(passwordService.isPasswordMatch(password, encodedPassword));
    }

    @Test
    void updatePassword() {
        //given
        String password = "abcd1234";
        String newPassword = "1234abcd";
        Email email = new Email("test@test.com");
        String encodedPassword = passwordService.validateAndEncodePassword(password);
        EmailCredential credential = EmailCredential.builder()
            .userId(1L)
            .email(email)
            .password(encodedPassword)
            .build();

        //when
        passwordService.updatePassword(credential, password, newPassword);

        //then
        assertTrue(passwordService.isPasswordMatch(newPassword, credential.getPassword()));
    }

    @Test
    void isValidPassword() {
        // Valid password
        assertNotNull(passwordService.validateAndEncodePassword("abcd1234"));

        // Need at least one alphabet
        assertThrows(InvalidPasswordException.class, () -> passwordService.validateAndEncodePassword("12345678"));
        // Need at least one number
        assertThrows(InvalidPasswordException.class, () -> passwordService.validateAndEncodePassword("abcdefgh"));
        // Need at least 8 characters
        assertThrows(InvalidPasswordException.class, () -> passwordService.validateAndEncodePassword("a1b2c3"));
        // Need at most 15 characters
        assertThrows(InvalidPasswordException.class, () -> passwordService.validateAndEncodePassword("a1b2c3d4e5f6g7h8i9j10"));
    }

    @Test
    void encodePassword() {
        String password = "abcd1234";
        String encodedPassword = passwordService.validateAndEncodePassword(password);

        assertTrue(passwordService.isPasswordMatch(password, encodedPassword));
    }

    @Test
    void isPasswordMatch() {
        String password = "abcd1234";   
        String encodedPassword = passwordService.validateAndEncodePassword(password);

        assertTrue(passwordService.isPasswordMatch(password, encodedPassword));

        // Wrong password
        assertFalse(passwordService.isPasswordMatch("abcd123", encodedPassword));
    }
}
