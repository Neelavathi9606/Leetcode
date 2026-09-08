class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,candidates,target,current,ans);
        return ans; 
    }
    public void solve (int index,int[] candidates,int target,List<Integer> current, List<List<Integer>>ans){
        //base
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        //no valid combnation
        if(index==candidates.length||target<0){
            return;
        }
        //pick
        current.add(candidates[index]);
        solve(index,candidates,target-candidates[index],current,ans);
        //backtrack
        current.remove(current.size()-1);
        //not pick
        solve(index+1,candidates,target,current,ans);
    }
}