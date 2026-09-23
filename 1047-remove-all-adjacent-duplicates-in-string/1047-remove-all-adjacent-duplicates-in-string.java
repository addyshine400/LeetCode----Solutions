class Solution {
    public String removeDuplicates(String s) {
        StringBuilder st = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int n = st.length();

            if (n > 0 && st.charAt(n - 1) == ch) {
                st.deleteCharAt(n - 1);   // pop
            } else {
                st.append(ch);            // push
            }
        }
        return st.toString();
    }
}