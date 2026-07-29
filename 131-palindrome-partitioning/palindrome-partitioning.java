class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        backtracking(s,0,new ArrayList<>(),result);
        return result;
        
    }
    private void backtracking(String s,int start,List<String>cur,List<List<String>>result){
        if(start==s.length()){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isP(s,start,end)){
                cur.add(s.substring(start,end+1));
                backtracking(s,end +1,cur,result);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isP(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}