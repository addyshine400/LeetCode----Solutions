class Solution {
    public int reverse(int x) {

        int ans = 0;

        while (x != 0) {

            // Last digit
            int digit = x % 10;

            // Remove last digit
            x = x / 10;

            // Positive overflow
            if (ans > Integer.MAX_VALUE / 10 ||
                (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Negative overflow
            if (ans < Integer.MIN_VALUE / 10 ||
                (ans == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Add digit to reversed number
            ans = ans * 10 + digit;
        }

        return ans;
    }
}