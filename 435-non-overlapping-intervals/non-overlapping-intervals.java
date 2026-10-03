class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int lastEndindex=intervals[0][1];
        int count=1;
        for(int i=1;i<n;i++){
            int start=intervals[i][0];
            if( start>=lastEndindex){
                count=count+1;
                lastEndindex=intervals[i][1];
            }

        }
        return n-count; 
        
    }
}