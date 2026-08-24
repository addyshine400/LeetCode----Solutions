class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch , 0) +1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int count = t.length();
        int minLen =  Integer.MAX_VALUE;
        String ans = "";
        for(int right = 0 ; right < s.length(); right++){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c,0)+1);

            if(tMap.containsKey(c)  && sMap.get(c)<= tMap.get(c)){
                count --;
            }

            while(count == 0){
                if((right - left + 1) < minLen ){
                    minLen = right - left +1 ;
                    ans = s.substring(left ,right +1);
                }

                char leftchar = s.charAt(left);
                sMap.put(leftchar , sMap.get(leftchar)-1);

                if(tMap.containsKey(leftchar) && sMap.get(leftchar)< tMap.get(leftchar)){
                    count ++ ;
                }
                left ++ ;
            }
        }
        return ans;
}
}