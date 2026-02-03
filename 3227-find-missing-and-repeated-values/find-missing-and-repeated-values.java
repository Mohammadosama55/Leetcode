class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        long m=(long) n*n;

        long expectedSum=m*(m+1)/2;
        long expectedSqSum=m*(m+1)*(2*m+1)/6;


        long actualSum=0;
        long actualSqSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                long val =grid[i][j];
                actualSum +=val;
                actualSqSum +=val *val;
            }
        }
        long diffSum=actualSum - expectedSum;
        long diffSqSum=actualSqSum - expectedSqSum;
        long sumAB=diffSqSum / diffSum;
        int a=(int)((diffSum + sumAB)/2);
        int b=(int)(sumAB-a);
        return new int[]{a, b};

        
    }
}