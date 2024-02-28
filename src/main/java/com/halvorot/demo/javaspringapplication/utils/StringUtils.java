package com.halvorot.demo.javaspringapplication.utils;

import java.util.Random;

public class StringUtils {

    private StringUtils() {
        // Hide default constructor
    }

    public static String generateRandomString(int length, Random random) {
        int asciiA = 97; // letter 'a'
        int asciiZ = 122; // letter 'z'

        return random.ints(asciiA, asciiZ + 1)
            .limit(length)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

}
