/*
 Design a stack that supports push, pop, top, and retrieving the minimum element
in constant time.  push(x) -- Push element x onto stack.  pop() -- Removes the
element on top of the stack.  top() -- Get the top element.  getMin() --
Retrieve the minimum element in the stack.    Example:  MinStack minStack = new
MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.    Subscribe to see which companies asked
this question    Show Tags   Stack  Design     Show Similar Problems   (H)
Sliding Window Maximum
*/

public class MinStack {
    long diff;
    Stack<Long> s;

    /** initialize your data structure here. */
    public MinStack() {

        s = new Stack<Long>();
    }

    public void push(int x) {
        if (s.isEmpty()) {
            s.push(0l);
            diff = x;
        } else {
            s.push(x-diff);
            if (x < diff) diff = x;
        }
    }

    public void pop() {
        if(s.isEmpty()) return;
        long pop = s.pop();
        if (pop < 0) diff -= pop;
    }

    public int top() {
        long top=s.peek();
        if (top>0){
            return (int)(top+diff);
        }else{
           return (int)(diff);
        }
    }

    public int getMin() {
        return (int)diff;
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


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
