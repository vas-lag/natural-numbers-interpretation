package org.example;

public class PhoneNumberValidator {
    protected static boolean isValid(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            return phoneNumber.startsWith("2") || phoneNumber.startsWith("69");
        } else if (phoneNumber.length() == 14) {
            return phoneNumber.startsWith("00302") || phoneNumber.startsWith("003069");
        } else {
            return false;
        }
    }
}
