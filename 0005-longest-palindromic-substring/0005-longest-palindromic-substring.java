class Solution {
     int start =0;
        int maxLen = 0;

    public String longestPalindrome(String s) {
       
        for(int i =0; i< s.length(); i++){
        expand(s,i,i);  // for odd length palindrome
        expand(s,i,i+1); // for even length palindrome
        }

          return s.substring(start,start + maxLen); // return the longest pallindrome
        }
    

       
       //expand around the centre and update longest pallindrome
        private void expand(String s, int left, int right)
        {
              while(left >=0 && right <s.length() && s.charAt(left) ==s.charAt(right)) 
              {
                left --;
                right ++;
               }
             // calculate the length of the pallindrome

             int len = right - left -1;
             if(len >maxLen){
             maxLen = len;
             start = left + 1;
             }





        

        
    }
}