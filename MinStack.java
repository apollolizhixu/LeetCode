class MinStack {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if (min.peek() == num) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
