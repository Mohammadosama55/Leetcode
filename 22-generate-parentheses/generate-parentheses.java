class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>result=new ArrayList<>();
        int l=0;
        int r=0;
        String s="";
        gen(l,r,n,result,s);
        return result;
        
    }
    private void gen(int l,int r,int n,List<String>result,String s){
        if(l==n &&r==n){
            result.add(s);
            return;
        }
        if(l<n){
            gen(l+1,r,n,result,s+"(");
        }
        if(r<l){
            gen(l,r+1,n,result,s+")");
        }
    }
}