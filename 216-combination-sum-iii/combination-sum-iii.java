class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(1,k,n,current,ans);
        return ans;
    }
    private void solve(int start,int k,int target,List<Integer> current,List<List<Integer>> ans){
        //base
        if(k==0 && target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(k==0 || target<0){
            return;
        }
        for(int i=start;i<=9;i++){
            current.add(i);
            solve(i+1,k-1,target-i,current,ans);
            current.remove(current.size()-1);
        }
    }
}