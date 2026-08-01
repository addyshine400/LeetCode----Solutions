class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0){   // to check array has no strings or null
            return "" ;
        }
        for(int i =0;i<strs[0].length();i++){ //taking  first string as refrence
             char ch = strs[0].charAt(i);
             for(int j =1; j< strs.length;j++){// compare this character with every other string
                if(i==strs[j].length() || strs[j].charAt(i)!=ch){ //to check whether the first string got ended "flownindex "= 0,1,2,3 if we enter 4 it will show error also to check if the character is diff
                    return strs[0].substring(0,i);
                }
             }
        }


          return strs[0];
        
    }
}