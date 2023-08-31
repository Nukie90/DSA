package code;

public class MyLinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    Node head = null;

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d) {
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    public int find(int d) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == d) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not found
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }

    public void insert(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }

    public void q1_rotate_clockwise(int k) {
        int linkSize = size();
        if (k == 0 || k >= linkSize) {
            return;
        }
        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null)
            return;
        Node kth = current;
        while (current.next != null)
            current = current.next;
        current.next = head;
        head = kth.next;
        kth.next = null;
    }

    public void q2_reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void q3_remove_dup() {
        Node current = head;

        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void q4_increment_digits() {
        boolean hasCarry = incrementHelper(head);

        if (hasCarry) {
            Node newHead = new Node(1);
            newHead.next = head;
            head = newHead;
        }
    }

    private boolean incrementHelper(Node node) {
        if (node == null) {
            return true;
        }

        boolean carry = incrementHelper(node.next);

        if (carry) {
            int sum = node.data + 1;
            node.data = sum % 10;
            return sum >= 10;
        }

        return false;
    }

    public boolean q5_isPalindrome() {
        int[] elements = new int[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data;
            current = current.next;
        }

        int left = 0;
        int right = elements.length - 1;
        while (left < right) {
            if (elements[left] != elements[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> (");
            sb.append(p.data);
            sb.append(") ");
            p = p.next;
        }
        sb.append("-> null");
        return sb.toString();
    }
}
