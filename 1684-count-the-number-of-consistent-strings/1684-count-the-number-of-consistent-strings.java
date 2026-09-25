class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        boolean[] allowedChar = new boolean[26];

        // Mark allowed characters
        for (char c : allowed.toCharArray()) {
            allowedChar[c - 'a'] = true;
        }

        int count = 0;

        // Check every word
        for (String word : words) {

            boolean consistent = true;

            for (char c : word.toCharArray()) {

                if (!allowedChar[c - 'a']) {
                    consistent = false;
                    break;
                }
            }

            if (consistent) {
                count++;
            }
        }

        return count;
    }
}