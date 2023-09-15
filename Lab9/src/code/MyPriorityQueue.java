package code;

public class MyPriorityQueue {
    MyMinHeap heap = new MyMinHeap();

    public void enqueue(int d) {
        if (!isFull()) {
            heap.insert(d);
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            return heap.remove();
        } else {
            return -1;
        }
    }

    public int front() {
        return heap.peek();
    }

    public boolean isFull() {
        return heap.isFull();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public String toString() {
        return heap.toString();
    }
}