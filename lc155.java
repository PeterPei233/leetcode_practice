class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> sk;
    int min;
    public MinStack() {
        sk = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        sk.push(x);
        if(x<min) min = x;
    }
    
    public void pop() {
        int x = sk.pop();
        if(x == min){
            if(sk.empty()) min = Integer.MAX_VALUE;
            else{
                min = sk.peek();
                for(int y:sk) {
                    if(y<min) min= y;
                }
            }
        }
    }
    
    public int top() {
        return sk.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */