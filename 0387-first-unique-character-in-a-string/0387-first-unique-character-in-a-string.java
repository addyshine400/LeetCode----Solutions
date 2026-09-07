class Solution {
    public int firstUniqChar(String s) {
        int[] freq= new int[26];
        for(char ch :s.toCharArray()){
            //it will break the stings into characters

         // countt the character
            freq[ ch - 'a']++;
        }
        // find the unique character
        for(int i = 0 ; i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
        
    }
}