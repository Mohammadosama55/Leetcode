class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] frq=new int[26];
        for(char c:tasks){
            frq[c-'A']++;
        }
        int max=0;
        for(int f:frq){
            if(f>max){
                max=f;
            }
        }
        int count=0;
        for(int f:frq){
            if(f==max){
                count++;
            }
        }
        int c=(max-1)*(n+1)+count;
        return Math.max(tasks.length,c);
    }
}