class Solution {
    public String reorganizeString(String s) {
        int []freq=new int[26];
        for(char f:s.toCharArray()){
            freq[f-'a']++;
        }
        int maxf=0;
        for(int f:freq){
            maxf=Math.max(f,maxf);
        }
        if(maxf>(s.length()+1)/2) return "";
       
        PriorityQueue<int[]>heap=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                heap.offer(new int[]{i,freq[i]});
            }
        }
        StringBuilder sb=new StringBuilder();
        int[] prev=null;
        while(!heap.isEmpty()){
            int []top=heap.poll();
            sb.append((char)('a'+top[0]));
            top[1]--;
            if(prev!=null && prev[1]>0)heap.offer(prev);
            prev=top;
        }
        return sb.toString();
        
    }
}