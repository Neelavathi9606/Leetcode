class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        else 
            return solve(nums,sum/2);
    }
    static boolean  solve(int nums[],int sum){
        boolean[][] t=new boolean  [nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++){
        for(int j=0;j<sum+1;j++){
        if(i==0){
            t[i][j]= false;
        }
        if(j==0){
            t[i][j]= true;
        }
        }
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
        if(nums[i-1]<=j){
            t[i][j]=t[i-1][j-nums[i-1]]||t[i-1][j];

        }
        else
            t[i][j]=t[i-1][j];
        }
        }
    
    return t[nums.length][sum];
}
}