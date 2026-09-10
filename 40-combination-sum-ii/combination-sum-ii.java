class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,target,candidates,ans,current);
        return ans;
    }
    private void findCombinations(int index,int target,int [] candidates, List<List<Integer>> ans,List<Integer> current){
        //base
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            //pick
            current.add(candidates[i]);
            findCombinations(i+1,target-candidates[i],candidates,ans,current);
            current.remove(current.size()-1);
        }
    }
}