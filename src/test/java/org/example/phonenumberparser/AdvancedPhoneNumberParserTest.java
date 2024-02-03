package org.example.phonenumberparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedPhoneNumberParserTest {
    AdvancedPhoneNumberParser advancedPhoneNumberParser;

    @BeforeEach
    public void instanciateSimplePhoneNumberParser() {
        advancedPhoneNumberParser = new AdvancedPhoneNumberParser();
    }

    @Test
    public void testEmptyInput() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("");
        assertTrue(phoneNumbers.size() == 1);
        assertEquals(phoneNumbers.get(0), "");
    }

    @Test
    public void testNoSplits() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("123");
        assertEquals(phoneNumbers.get(0), "123");
    }

    @Test
    public void testEndingWithZero() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("40 5");
        assertTrue(phoneNumbers.contains("405"));
        assertTrue(phoneNumbers.contains("45"));
    }

    @Test
    public void testSplitTwoDigits() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("45");
        assertTrue(phoneNumbers.contains("45"));
        assertTrue(phoneNumbers.contains("405"));
    }

    @Test
    public void testSplitThreeDigits() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("456");
        assertTrue(phoneNumbers.contains("456"));
        assertTrue(phoneNumbers.contains("40056"));
        assertTrue(phoneNumbers.contains("4506"));
    }

    @Test
    public void testEndingInOneZero() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("40 5");
        assertTrue(phoneNumbers.contains("405"));
        assertTrue(phoneNumbers.contains("45"));
    }

    @Test
    public void testEndingInTwoZeros() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("400 56");
        assertTrue(phoneNumbers.contains("456"));
        assertTrue(phoneNumbers.contains("40056"));
        assertTrue(phoneNumbers.contains("4506"));
    }

    @Test
    public void testThreeDigitsWithMiddleZero() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("405");
        assertTrue(phoneNumbers.contains("4005"));
        assertTrue(phoneNumbers.contains("405"));
    }

    @Test
    public void testComplexInput() {
        List<String> phoneNumbers = advancedPhoneNumberParser.parsePhoneNumber("2 10 69 30 6 6 4");
        assertTrue(phoneNumbers.contains("2106930664"));
        assertTrue(phoneNumbers.contains("210693664"));
        assertTrue(phoneNumbers.contains("2106093664"));
        assertTrue(phoneNumbers.contains("21060930664"));
    }
}
