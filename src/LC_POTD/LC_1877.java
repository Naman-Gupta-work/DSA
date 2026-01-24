package LC_POTD;

import java.util.Arrays;

public class LC_1877 {
    public static void main(String[] args) {
        int [] arr ={8,1,7,2,6,3,5,4,324,88};
        System.out.println(minPairSum(arr));
    }
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l =0, r = nums.length-1;
        int minimum =0;
        while(l<r){
            if(nums[l]+nums[r]>minimum){
                minimum=nums[l]+nums[r];
            }
            l++;
            r--;
        }
        return minimum;
    }
}
