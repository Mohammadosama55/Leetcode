class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                stack.pop();

            }else if(op.equals("D")){
                int top=stack.peek();
                stack.push(2*top);
            }else if(op.equals("+")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        for(int s:stack){
            sum +=s;
        }
        return sum;
        
    }
}