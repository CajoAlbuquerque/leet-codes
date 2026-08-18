package com.cajoalbuquerque;

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char charI = s.charAt(i);
            while (!isAlphanumeric(charI) && i < s.length() - 1) {
                i++;
                charI = s.charAt(i);
            }

            char charJ = s.charAt(j);
            while (!isAlphanumeric(charJ) && j > 0) {
                j--;
                charJ = s.charAt(j);
            }

            if (i > j)
                return true;

            if (Character.toLowerCase(charI) != Character.toLowerCase(charJ))
                return false;

            i++;
            j--;
        }

        return true;
    }

    private boolean isAlphanumeric(char character) {
        return (character >= '0' && character <= '9')
                || (character >= 'A' && character <= 'Z')
                || (character >= 'a' && character <= 'z');
    }
}