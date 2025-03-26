package edu.uoc.pac2;

public class CaesarCipherDecoder {

    public static int[] calculateFrequency(String encryptedMessage) {
        //TODO
        /** 26 abecedarium characters taken into account (ñ is excluded) to avoid mistakes**/
    int[] frequency = new int[26];
    if (encryptedMessage == null || encryptedMessage.isEmpty()) {
        return frequency;
    }
    for (int i=0; i<encryptedMessage.length(); i++) {
        char c= encryptedMessage.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            frequency[c-'A']++;
        }
    }
    return frequency;
    }

    public static char findMostFrequentLetter(String encryptedMessage) {
        //TODO
        int [] frequency = calculateFrequency(encryptedMessage);
        int maxCount = 0;
        /** Default value (A) if there are no letters. ñ cannot be used or it will fail the given tests**/
        char mostFrequent = 'A';

        for (int i=0; i<frequency.length; i++) {
            if (frequency[i] > maxCount) {
                maxCount = frequency[i];
                mostFrequent = (char) ('A' + i);
            }
        }
        return mostFrequent;
    }

    public static int calculateShift(String encryptedMessage) {
        //TODO
        char mostFrequent = findMostFrequentLetter(encryptedMessage);
        int shift = mostFrequent - 'E';
        if (shift < 0) {
            shift += 26;
        }
        return shift;
    }

    public static String decryptMessage(String encryptedMessage) {
        //TODO
        if (encryptedMessage == null || encryptedMessage.isEmpty()) {
            return "Empty Message";
        }

        int shift = calculateShift(encryptedMessage);
        StringBuilder decrypted = new StringBuilder(encryptedMessage.length());

        for (int i=0; i<encryptedMessage.length(); i++) {
            /**Changed value of "i" to change EEEEEEEEEEEEEEEEE to "where the wind blows..." **/
        char c = encryptedMessage.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            int newPos = c - shift;
            if (newPos < 'A') {
                newPos += 26;
            }
            decrypted.append((char) newPos);
        } else {
            decrypted.append(c);
        }
    }
    return decrypted.toString();
    }
}
