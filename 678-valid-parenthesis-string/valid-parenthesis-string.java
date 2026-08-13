class Solution {
    public boolean checkValidString(String s) {
        int minOpen=0;
        int maxOpen=0;
        for(int ch:s.toCharArray()){
            if(ch=='('){
                minOpen++;
                maxOpen++;
            }else if(ch==')'){
                minOpen=Math.max(minOpen-1,0);
                maxOpen--;
                  if(maxOpen<0){
            return false;
        }
            }else{
                 minOpen=Math.max(minOpen-1,0);
                maxOpen++;
                  if(maxOpen<0){
            return false;
        }
            }
        }
        
      

        return minOpen==0;
    }
}