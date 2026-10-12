class Solution {
    public boolean isAnagram(String s, String t) {
       
       if(s.length()!=t.length()){
            return false;
       }

        int []freq = new int[26];
        for(int i=0;i<s.length();i++){
             freq[s.charAt(i)-'a']++; // s ki frequecy increse
             freq[t.charAt(i)-'a']--; // t ki minus

        }
        
        // Step 4: Check karo sab frequencies zero hain ya nahi
        for(int i = 0 ; i<26;i++){
            
           if(freq[i]!=0){

             return false;

           }

        }

        //sb freq equal hai
        return true;
        
    }
}