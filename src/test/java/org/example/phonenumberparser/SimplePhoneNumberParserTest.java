package org.example.phonenumberparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimplePhoneNumberParserTest {
    SimplePhoneNumberParser simplePhoneNumberParser;

    @BeforeEach
    public void instanciateSimplePhoneNumberParser() {
        simplePhoneNumberParser = new SimplePhoneNumberParser();
    }

    @Test
    public void testEmptyInput() {
        List<String> phoneNumbers = simplePhoneNumberParser.parsePhoneNumber("");
        assertTrue(phoneNumbers.size() == 1);
        assertEquals(phoneNumbers.get(0), "");
    }

    @Test
    public void testSimpleCase() {
        List<String> phoneNumbers = simplePhoneNumberParser.parsePhoneNumber("123 456");
        assertTrue(phoneNumbers.size() == 1);
        assertEquals(phoneNumbers.get(0), "123456");
    }

    @Test
    public void testMultiplePartLength() {
        List<String> phoneNumbers = simplePhoneNumberParser.parsePhoneNumber("123 45 6 78 9");
        assertTrue(phoneNumbers.size() == 1);
        assertEquals(phoneNumbers.get(0), "123456789");
    }
}
