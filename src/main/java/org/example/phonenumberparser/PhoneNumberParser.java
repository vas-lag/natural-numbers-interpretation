package org.example.phonenumberparser;

import java.util.List;

public interface PhoneNumberParser {
    List<String> parsePhoneNumber(String input);
}
