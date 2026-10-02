class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    void backtrack(List<String> ans, String s, int open, int close, int n) {

        // Complete string
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add '('
        if (open < n) {
            backtrack(ans, s + "(", open + 1, close, n);
        }

        // Add ')'
        if (close < open) {
            backtrack(ans, s + ")", open, close + 1, n);
        }
    }
}