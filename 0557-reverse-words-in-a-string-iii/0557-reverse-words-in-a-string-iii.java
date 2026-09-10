class Solution {
    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int left = 0;

        for (int i = 0; i <= arr.length; i++) {

            // word ends when we find space or reach the end
            if (i == arr.length || arr[i] == ' ') {

                int right = i - 1;

                // reverse current word
                while (left < right) {

                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }

                // move to next word
                left = i + 1;
            }
        }

        return new String(arr);
    }
}