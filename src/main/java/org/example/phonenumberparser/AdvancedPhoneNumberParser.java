package org.example.phonenumberparser;

import java.util.ArrayList;
import java.util.List;

public class AdvancedPhoneNumberParser implements PhoneNumberParser {
    public List<String> parsePhoneNumber(String input) {
        List<String> possiblePhoneNumbers = new ArrayList<>();
        String[] parts = input.split(" ");
        StringBuilder phoneNumber = new StringBuilder();
        generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(), 0);
        return possiblePhoneNumbers;
    }

    private void generatePossiblePhoneNumbers(List<String> possiblePhoneNumbers, String[] parts, StringBuilder currentPhoneNumber, int index) {
        if (parts.length == index) {
            possiblePhoneNumbers.add(currentPhoneNumber.toString());
            return;
        }
        String currentPart = parts[index];
        generatePossiblePhoneNumbers(possiblePhoneNumbers, parts,  new StringBuilder(currentPhoneNumber).append(currentPart), index + 1);
        if (currentPart.length() == 2 && Integer.parseInt(currentPart) > 20 ) {
            // e.g 25 -> 25 or 205
            if (!currentPart.endsWith("0")) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.charAt(0)).append("0").append(currentPart.charAt(1)), index + 1);
            }
            // e.g 30 6 -> 306 or 36
            if (Integer.parseInt(currentPart) % 10 == 0 && parts.length > index + 1 && parts[index + 1].length() == 1 && !parts[index + 1].equals("0")) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.charAt(0)).append(parts[index + 1]), index + 2);
            }
        }
        if (currentPart.length() == 3) {
            // e.g. 234 -> 234 or 20034 or 2304
            if (!currentPart.contains("0")) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.charAt(0)).append("00").append(currentPart.substring(1)), index+1);
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.substring(0, 2)).append("0").append(currentPart.charAt(2)), index+1);
            }
            // e.g. 250 6 -> 2506 or 256
            if (currentPart.endsWith("0") && parts.length > index + 1 && parts[index + 1].length() == 1) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.substring(0, 2)).append(parts[index + 1]), index+2);
            }
            // e.g. 300 54 -> 30054 or 354 or 3504
            if (currentPart.endsWith("00") && parts.length > index + 1 && parts[index + 1].length() == 2) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.charAt(0)).append(parts[index + 1]), index+2);
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.charAt(0)).append(parts[index + 1].charAt(0)).append("0").append(parts[index + 1].charAt(1)), index+2);
            }
            // e.g. 305 -> 305 or 3005
            if (currentPart.charAt(1) == '0' && !currentPart.endsWith("0")) {
                generatePossiblePhoneNumbers(possiblePhoneNumbers, parts, new StringBuilder(currentPhoneNumber).append(currentPart.substring(0,2)).append("0").append(currentPart.charAt(2)), index+1);
            }
        }
    }
}
