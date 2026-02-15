class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0);
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove=0;
        int lastend=Integer.MIN_VALUE;
        for(int[]interval:intervals){
            int start=interval[0];
            int end=interval[1];
            if(start<lastend){
                remove++;
            }else{
                lastend=end;
            }
        } 
        return remove;
    }
}