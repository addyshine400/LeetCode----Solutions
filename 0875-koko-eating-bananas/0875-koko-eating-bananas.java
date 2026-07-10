class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = piles[0];
        // FIND MAXIMUM PILES
        for(int pile:piles){
            if(pile > high){
                high = pile;
            }
        }
        while(low<high){
            int mid = low +(high - low)/2;
            int hours =0;
            // calculaye total hours needed at speed = mid
            for( int pile : piles){
                hours +=(pile + mid -1)/mid;
            }
            if(hours <= h){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }
        return low;
        
    }
}