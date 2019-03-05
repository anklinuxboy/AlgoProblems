import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
     * for an array, find unique triplets such that a + b + c = 0
     */

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> triplets = new ArrayList<>();

        // sort the array so that the first number is the most negative and the last number is the most positive
        Arrays.sort(nums);
        // a + b + c = 0; so a + b = 0 - c
        for (int i = 0; i < nums.length; i++) {
            // skip duplicate numbers in the array
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int updateTarget = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                // go ahead in list to find bigger numbers
                if (sum < updateTarget) {
                    l++;
                } else if (sum > updateTarget) { // find a smaller number in list
                    r--;
                } else {
                    // skip duplicates
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    triplets.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }

        return triplets;
    }
}
