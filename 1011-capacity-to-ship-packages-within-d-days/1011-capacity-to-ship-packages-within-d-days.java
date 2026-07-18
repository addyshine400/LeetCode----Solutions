class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Find search range
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;   // Try smaller capacity
            } else {
                low = mid + 1; // Increase capacity
            }
        }

        return low;
    }

    // Check if capacity is enough
    private boolean canShip(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }

        return requiredDays <= days;
    }
}