class Solution {
    public int minAddToMakeValid(String s) {
        int openneed=0;
        int addition=0;
        for(int c:s.toCharArray()){
            
            if(c=='('){
                openneed++;
            }else{
                if(openneed>0){
                    openneed --;
                }else{
                    addition++;
                }
            }
        }
        return addition+openneed;
    }
}