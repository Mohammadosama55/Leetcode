class Solution {
    public boolean mergeTriplets(int[][] t, int[] ta) {
        boolean x=false;
        boolean y=false;
        boolean z=false;
        for(int []tp:t){
            if(tp[0]<=ta[0] && tp[1]<=ta[1] && tp[2]<=ta[2]){
                if(tp[0]==ta[0]){
                    x=true;
                }
                if(tp[1]==ta[1]){
                    y=true;
                }
                if(tp[2]==ta[2]){
                    z=true;
                }
            }
        }
        return x && y && z;
        
    }
}