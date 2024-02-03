package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {

    @Test
    public void testValidPhoneNumbers() {
        assertTrue(PhoneNumberValidator.isValid("2106930664"));
        assertTrue(PhoneNumberValidator.isValid("00306974092252"));
    }

    @Test
    public void testInvalidPhoneNumbers() {
        // should fail on length
        assertFalse(PhoneNumberValidator.isValid("302558"));
        assertFalse(PhoneNumberValidator.isValid("21069306604"));
        // should fail on starting digits
        assertFalse(PhoneNumberValidator.isValid("11069306604"));
        assertFalse(PhoneNumberValidator.isValid("00316974092252"));
    }
}
