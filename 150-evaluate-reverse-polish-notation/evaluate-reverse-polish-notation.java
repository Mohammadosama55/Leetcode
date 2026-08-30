class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>s1=new Stack<>();
        for(String token:tokens){
            if(token.equals("+")){
             
                s1.push(s1.pop()+s1.pop());
            }else if(token.equals("-")){
                int b=s1.pop();
                int a=s1.pop();
                s1.push(a-b);

            }else if(token.equals("*")){
                
                s1.push(s1.pop()*s1.pop());

            }else if(token.equals("/")){
                int b=s1.pop();
                int a=s1.pop();
                s1.push(a/b);

            }else{
                s1.push(Integer.parseInt(token));
            }
        }
        return s1.pop();
    }
}