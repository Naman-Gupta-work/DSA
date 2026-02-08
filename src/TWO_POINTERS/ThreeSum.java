package TWO_POINTERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for( int i = 0 ;i<nums.length;i++){

            if( i>0 &&  nums[i]==nums[i-1] ){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){

                if(nums[j]+nums[k]==-nums[i]){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    pair.add(nums[k]);
                    result.add(pair);
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;

                    j++;
                    k--;
                }
                else if( nums[j]+nums[k]>-nums[i]){
                    k--;
                }
                else{
                    j++;
                }
            }


        }
        return result;
    }
}
