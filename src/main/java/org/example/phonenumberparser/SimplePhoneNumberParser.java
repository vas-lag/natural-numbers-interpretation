package org.example.phonenumberparser;

import java.util.ArrayList;
import java.util.List;

public class SimplePhoneNumberParser implements PhoneNumberParser {
    public List<String> parsePhoneNumber(String input) {
        String[] parts = input.split(" ");
        StringBuilder phoneNumber = new StringBuilder();
        for (String part : parts) {
            phoneNumber.append(part);
        }
        List<String> possiblePhoneNumbers = new ArrayList<>();
        possiblePhoneNumbers.add(phoneNumber.toString());
        return possiblePhoneNumbers;
    }
}
