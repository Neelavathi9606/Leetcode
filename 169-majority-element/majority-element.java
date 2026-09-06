class Solution {
    public int majorityElement(int[] nums) {
        
       /* for(int i = 0; i < nums.length; i++) {
            int count = 0;
            
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            
            if(count > nums.length / 2) {
                return nums[i];
            }
        }
        
        return -1;
    }*/
    int element = 0;
        int count = 0;

        // Step 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                element = num;
            }

            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == element) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return element;
        }

        return -1; // No majority element
    }

}
    
