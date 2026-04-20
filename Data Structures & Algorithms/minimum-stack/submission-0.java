class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        s1.push(val);
        if (s2.isEmpty() || val <= s2.peek()) {
            s2.push(val);
        } else {
            s2.push(s2.peek());
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
