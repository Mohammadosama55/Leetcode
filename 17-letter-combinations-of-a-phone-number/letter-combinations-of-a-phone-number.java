class Solution {
    private static final String[] MAPPING = {
        "",     
        "",    
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno", 
        "pqrs", 
        "tuv",  
        "wxyz"  
    };
    public List<String> letterCombinations(String digits) {
        List<String>result=new ArrayList<>();
        if(digits==null || digits.isEmpty()){
            return result;
        }
        
        backtracking(digits,0,new StringBuilder(),result);
        return result;
    }
    private void backtracking(String digits,int start,StringBuilder cur,List<String>result){
        if(start==digits.length()){
            result.add(cur.toString());
            return;
        }
        
        char digit = digits.charAt(start);
        String letters = MAPPING[digit - '0'];
        
        
        for (char c : letters.toCharArray()) {
            
            cur.append(c);
           
            backtracking(digits, start+ 1, cur, result);
            
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}