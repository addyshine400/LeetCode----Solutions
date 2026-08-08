class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10 == 0 && x!=0)){
            return false ;
        }
        int rev = 0 ;
        while( x > rev) {
            while (x > rev) {

    int lastDigit = x % 10;  // get last digit

    rev = rev * 10 + lastDigit;  // add digit to reverse

    x = x / 10;  // remove last digit
}
        }

        return x == rev ||  x == rev /10;
        
    }
}