class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
       
        List<List<Integer>>g=new ArrayList<>();
        for(int i=0;i<=n;i++){
            g.add(new ArrayList<>());
        }
        for(int []e:edges){
             boolean []V=new boolean[n+1];
            int u=e[0];
            int v=e[1];
            if(dfs(g,u,v,V)){
                return e;
            }
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return new int[0];
        
    }
    private boolean dfs(List<List<Integer>>g,int c,int t,boolean []v){
        if(c==t){
            return true;
        }
        v[c]=true;
        for(int n:g.get(c)){
            if(!v[n]){
                if(  dfs(g,n,t,v)){
                    return true;
                }
            }
          
        }
        return false;
    }
}