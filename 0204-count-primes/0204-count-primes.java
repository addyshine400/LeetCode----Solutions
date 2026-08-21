class Solution {
    public int countPrimes(int n) {

        boolean[] isComposite = new boolean[n];

        int count = 0;

        for (int i = 2; i < n; i++) {

            if (!isComposite[i]) { // to check not composite, then it is prime
                count++; // increase the count
     
         //  We only need to start marking multiples from i × i.
                if ((long) i * i < n) {

                 //   Marks all multiples of i.
                    for (int j = i * i; j < n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }

        return count;
    }
}