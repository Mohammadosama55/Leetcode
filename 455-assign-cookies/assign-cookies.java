class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0;
        int cs=0;
        int ss=0;
        while(c<g.length&&cs<s.length){
            if(s[cs]>=g[c]){
                c++;
                cs++;
                ss++;
            }else{
                cs++;
            }
        }
        return ss;
    }
}