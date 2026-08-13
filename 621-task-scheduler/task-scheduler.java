class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []f=new int[26];
        for(char c:tasks){
            f[c-'A']++;
        }
        int maxF=0;
        for(int fq:f){
            maxF=Math.max(maxF,fq);
        }
        int countMax=0;
        for(int fq:f){
            if(fq==maxF){
                countMax++;
            }
        }
        int condidate=(maxF-1)*(n+1)+countMax;
        return Math.max(tasks.length,condidate);
        
    }
}