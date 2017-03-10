import java.util.*;

public class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    
    Queue(int n) {
        this.queue = (T[]) new Object[n];
        this.front = 0;
        this.rear = 0;
    }

    T deQueue() {
        if ((this.rear-this.front)<=0) {
            throw new Error("queue is empty");
        }
        return this.queue[this.front++];
    }

    void enQueue(T t) {
        if ((this.rear+1) >=queue.length)
            throw new Error("queue OverFlow");

        this.queue[rear++] = t;
    }
    void print(){
        for(int i=this.front;i<this.rear;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
    public static void main(String arg[]){
        Queue<Integer> Q=new Queue(10);
        
        Q.enQueue(10);
        Q.enQueue(15);
        Q.enQueue(16);
        Q.enQueue(17);
        Q.enQueue(18);
        Q.enQueue(19);
        Q.enQueue(20);
        Q.enQueue(21);
        Q.print();
        System.out.print(Q.deQueue());
        System.out.print(Q.deQueue());
        System.out.print(Q.deQueue());
        System.out.print(Q.deQueue());
        System.out.println("");
        Q.print();
        
    }

}