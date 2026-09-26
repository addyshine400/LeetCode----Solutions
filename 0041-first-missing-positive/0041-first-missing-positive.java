class Solution {
    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // सभी numbers set में डालो
        for (int num : nums) {
            set.add(num);
        }

        // 1 से check करना शुरू करो
        int i = 1;

        while (set.contains(i)) {
            i++;
        }

        return i;
    }
}