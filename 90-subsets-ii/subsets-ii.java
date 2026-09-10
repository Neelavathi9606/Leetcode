import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        findSubsets(0, nums, current, ans);

        return ans;
    }

    private void findSubsets(int index, int[] nums,
                             List<Integer> current,
                             List<List<Integer>> ans) {

        // Add current subset
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Skip duplicate at the same level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pick
            current.add(nums[i]);

            findSubsets(i + 1, nums, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}