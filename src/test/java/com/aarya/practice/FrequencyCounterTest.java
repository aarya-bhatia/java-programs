package com.aarya.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrequencyCounterTest {

    @Test(expected = NullPointerException.class)
    public void testEmptyMap() {
        FrequencyCounter fc = new FrequencyCounter();
        fc.getSummary();
    }

    @Test
    public void testCharacterFrequency() {
        String str = "Hello, my name is Aarya";
        FrequencyCounter fc = new FrequencyCounter();
        for(char c: str.toLowerCase().toCharArray()) {

            // ignore non word characters
            if(c == ' ' || c == '\n' || c == '\r') { continue; }

            System.out.println("Adding: " + c);
            fc.add(c);
        }

        char[] summary=fc.getSummary();

        // expected: 'a', actual: summary[0]
        assertEquals("highest occuring char should be a",'a',summary[0]);
    }
}
