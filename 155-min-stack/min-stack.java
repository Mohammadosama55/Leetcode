class MinStack {

    private Stack<Integer> s1;
    private Stack<Integer>minS;
    public MinStack() {
        s1=new Stack<>();
        minS=new Stack<>();

        
    }
    
    public void push(int value) {
        s1.push(value);
        if(minS.isEmpty()){
            minS.push(value);
        }else{
            minS.push(Math.min(value,minS.peek()));
        }
        
    }
    
    public void pop() {
        s1.pop();
        minS.pop();
        
    }
    
    public int top() {
      return  s1.peek();
        
    }
    
    public int getMin() {
      return  minS.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */