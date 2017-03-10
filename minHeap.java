import java.util.Scanner;

public class minHeap {
    private int capacity;
    private int size;
    int items[];
minHeap(){
    capacity=10;
    size=0;
    items=new int[capacity];
}
    int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    boolean hasParent(int index) {
        return getParentIndex(index) < index;
    }

    int leftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    int rightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }

    int parent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    public void swap(int index, int index1) {
        int temp = items[index];
        items[index] = items[index1];
        items[index1] = temp;
    }

    public boolean ensureCapacity() {
        return true;//need to impliment 
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException("");
        return items[0];
    }

    public int poll() {
        if (size == 0)
            throw new IllegalStateException("");
        int item = items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
       // if (ensureCapacity()) {
            items[size] = item;
            size++;
            heapifyUp();
            
        //}

    }

    public void heapifyDown() {
        int index = 0;
        System.out.print("heapifyDown");
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

        }

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && (parent(index) > items[index])) {
            swap(getParentIndex(index), index);
            index =getParentIndex(index);
        }
    }

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);
        minHeap mn = new minHeap();
        mn.add(5);
        mn.add(2);
        mn.add(4);
        mn.add(9);
        mn.add(1);
        mn.add(22);
        mn.print();

    }
}