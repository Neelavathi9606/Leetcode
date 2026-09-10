import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] keypad = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        StringBuilder current = new StringBuilder();

        solve(0, digits, keypad, current, ans);

        return ans;
    }

    private void solve(int index,
                       String digits,
                       String[] keypad,
                       StringBuilder current,
                       List<String> ans) {

        // Base case
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = keypad[digits.charAt(index) - '0'];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            // Pick
            current.append(letters.charAt(i));

            // Move to next digit
            solve(index + 1, digits, keypad, current, ans);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}