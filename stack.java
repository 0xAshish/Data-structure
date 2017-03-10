import java.util.*;

public class stack<T> {
    private T[] stack;
    private int top;

    stack(int n) {
        this.stack = (T[]) new Object[n];
        this.top = -1;
    }

    T peek() {
        if (this.top == -1) {
            throw new Error("stack is empty");
        }
        return this.stack[top - 1];
    }

    void push(T t) {
        if ((top+1) >=stack.length)
            throw new Error("stack OverFlow");

        this.stack[++top] = t;
    
    }
    void print(){
        for(int i=0;i<stack.length;i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
    T pop() {
        if (stack.length < 0) {
            throw new Error("stack underflow");   
        }
        return stack[top--];
    }
    public static void main(String arg[]){
        stack<Integer> stk=new stack(10);
        stk.pop();
        stk.push(10);
        stk.push(15);
        stk.push(16);
        stk.push(17);
        stk.push(18);
        stk.push(19);
        stk.push(20);
        stk.push(21);
        stk.print();
        System.out.print(stk.pop().toString());//maybe we need it sometime ;-)
        System.out.print(stk.pop());
        System.out.print(stk.pop());
        System.out.print(stk.pop());
    }

}