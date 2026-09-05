class FreqStack {
    private HashMap<Integer,Integer>freq;
    private HashMap<Integer,Stack<Integer>>g;
    private int maxF;

    public FreqStack() {
        freq=new HashMap<>();
        g=new HashMap<>();
        maxF=0;
        
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        g.putIfAbsent(f,new Stack<>());
       
        g.get(f).push(val);
       
        maxF=Math.max(maxF,f);

        
    }
    
    public int pop() {
        Stack<Integer> stack=g.get(maxF);
        int val=stack.pop();
        freq.put(val,freq.get(val)-1);
        if (stack.isEmpty()) {
            maxF--;
        }
        
        return val;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */