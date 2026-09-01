class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int ast:asteroids){
            if(ast>0){
                stack.push(ast);
            }else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()< -ast){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(ast);
                }else if(stack.peek()== -ast){
                    stack.pop();
                }
            }
        }
        int []result=new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}