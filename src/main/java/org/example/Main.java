package org.example;

import org.example.phonenumberparser.AdvancedPhoneNumberParser;
import org.example.phonenumberparser.PhoneNumberParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phone number");
        String input = scanner.nextLine();

        // SimplePhoneNumberParser could also be used here
        PhoneNumberParser advancedPhoneNumberFormatter = new AdvancedPhoneNumberParser();
        List<String> possiblePhoneNumbers = advancedPhoneNumberFormatter.parsePhoneNumber(input);
        for (int interpretation = 0; interpretation < possiblePhoneNumbers.size(); interpretation++) {
            String phoneNumber = possiblePhoneNumbers.get(interpretation);
            String isValidText = null;
            if (PhoneNumberValidator.isValid(phoneNumber)) {
                isValidText = "[phone number: VALID]";
            } else {
                isValidText = "[phone number: INVALID]";
            }
            System.out.println("Interpretation " + (interpretation + 1) + ": " + phoneNumber + "    " + isValidText);
        }
    }
}