class Solution {
    public int characterReplacement(String s, int k) {

        int [] freq =  new int[26];
        int left =0;
        int maxfreq =0;
        int ans=0;

        for(int  right = 0 ; right<s.length();right++){

           //frequency check krne k liye 
            freq[s.charAt(right) -'A']++;
            
            // max frequency check krne k liye
            maxfreq = Math.max(maxfreq,freq[s.charAt(right) -'A']);

            //current window ki lwngth
            int windowlength = right-left+1;

            //kitne changes krne padega
             int change = windowlength - maxfreq;


             // invalid condition me

             if(change >k){

                //left character ko remove karo
                 freq[s.charAt(left) -'A']--;

                 //left pointerko aage badhao
                 left++;
             }

             //maximum answer ko update karo

             ans=Math.max(ans,right-left+1);

        } 
        return ans;

    }
}