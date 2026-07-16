class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = findMax(weights);
        int high = findSum(weights);

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int capacity, int days) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }

        return requiredDays <= days;
    }

    private int findMax(int[] weights) {

        int max = weights[0];

        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }

        return max;
    }

    private int findSum(int[] weights) {

        int sum = 0;

        for (int weight : weights) {
            sum += weight;
        }

        return sum;
    }
}