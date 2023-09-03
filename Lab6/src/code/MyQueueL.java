package code;

public class MyQueueL {
    public class Node {
        String data;
        Node next;

        public Node(String d) {
            data = d;
        }
    }

    private Node head, tail;

    public MyQueueL() {
        head = tail = null;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(String d) {
        Node p = new Node(d);
        if (head == null)
            head = tail = p;
        else {
            tail.next = p;
            tail = tail.next;
        }
    }

    public String dequeue() {
        String d = head.data;
        head = head.next;
        return d;
    }

    /* isFull() isEmpty() */
    public String top() {
        return head.data;
    }

    public String getLast() {
        return tail.data;
    }

    public String dumpToString() {
        StringBuffer sb = new StringBuffer();
        Node n = head;
        while (n != null) {
            sb.append(n.data + " ");
            n = n.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First->");
        Node temp = head;
        while (temp != null) {
            sb.append(
                    temp.data).append("->");
            temp = temp.next;
        }
        sb.append("Last");
        return sb.toString();
    }
}