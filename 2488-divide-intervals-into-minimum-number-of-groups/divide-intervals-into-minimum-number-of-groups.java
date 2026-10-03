class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int[] start=new int[n];
        int [] end=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];

        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int groups=0;
        int maxgroups=0;
        while(i<n){
            if(start[i]<=end[j]){
                groups++;
                maxgroups=Math.max(maxgroups,groups);
                i++;

            }
            else{
                groups--;
                j++;
            }
        }
        return maxgroups;
    }
}

