class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int candidate1=0;
        int candidate2=0;
        int count1=0;
        int count2=0;
        
        //selecting candidates
        for(int num:nums){
            if(count1 > 0 && num==candidate1){
                count1++;
            }
            else if( count2> 0 && num==candidate2){
                count2++;
            }
            else if ( count1==0){
                candidate1= num;
                count1++;
            }
            else if( count2==0){
                candidate2=num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

         count1=0;
        count2=0;

        // for finding the frequencies
        for(int num:nums){
           
            if(num==candidate1){
                count1++;
            }
            else if(  num == candidate2){
                count2++;
        
            }


        }

        //storing valid result
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        if( count1 > n/3){
            result.add(candidate1);
        }
       if( count2>n/3 && candidate1 != candidate2){
            result.add(candidate2);
        }

        return result;


    }
}