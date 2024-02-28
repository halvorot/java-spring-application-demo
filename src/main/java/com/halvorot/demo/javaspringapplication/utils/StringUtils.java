package com.halvorot.demo.javaspringapplication.utils;

import java.util.Random;

public class StringUtils {

    public static String generateRandomString(int length) {
        int asciiA = 97; // letter 'a'
        int asciiZ = 122; // letter 'z'
        Random random = new Random();

        return random.ints(asciiA, asciiZ + 1)
            .limit(length)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

}
