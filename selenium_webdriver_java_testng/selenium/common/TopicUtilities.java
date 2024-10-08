package common;

import java.nio.charset.Charset;
import java.util.Random;

public class TopicUtilities {

    public static String randomString(int length) {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String randomStringOfNumber(int length) {

        Random random = new Random();
        return String.valueOf(random.nextInt(length));
    }

}
