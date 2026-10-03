import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, ans);

        return ans;
    }

    public void solve(int index, int[] nums,
                      List<Integer> current,
                      List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Pick the element
        current.add(nums[index]);

        solve(index + 1, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Don't pick the element
        solve(index + 1, nums, current, ans);
    }
}