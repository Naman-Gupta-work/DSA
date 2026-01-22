package LC_POTD;

import java.util.ArrayList;
import java.util.List;


//Given an array nums, you can perform the following operation any number of times:
//
//Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
//Replace the pair with their sum.
//Return the minimum number of operations needed to make the array non-decreasing.
//
//An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

public class LC_3507 {
    class Solution {
        public int minimumPairRemoval(int[] nums) {

            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);

            int ans = 0;

            // Check if sorted; if not, perform a merge
            while (!isSorted(list)) {
                list = performMerge(list);
                ans++;
            }
            return ans;
        }

        private List<Integer> performMerge(List<Integer> list) {
            int minSum = Integer.MAX_VALUE;
            int pos = 0;

            // 1. Find the leftmost minimum adjacent pair
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum; // FIXED: Must update minSum
                    pos = i;
                }
            }

            // 2. Create the new reduced list
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i == pos) {
                    result.add(list.get(i) + list.get(i + 1));
                    i++; // Skip the second element of the pair
                } else {
                    result.add(list.get(i));
                }
            }
            return result;
        }

        private boolean isSorted(List<Integer> list) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
