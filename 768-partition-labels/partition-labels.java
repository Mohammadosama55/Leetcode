class Solution {
    public List<Integer> partitionLabels(String s) {
        int []last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        List<Integer>result=new ArrayList<>();
        int ps=0;
        int pe=0;
        for(int i=0;i<s.length();i++){
            pe=Math.max(pe,last[s.charAt(i)-'a']);
            if(i==pe){
                int size=i-ps+1;
                result.add(size);
                ps=i+1;
            }
        }
        return result;
        
    }
}