package code;

public class MyArray {
    protected int MAX_SIZE = 100_000;
    protected int data[];
    protected int size = 0;

    public MyArray(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
        size = 0;
    }

    public MyArray() {
        this(100_000); // Default maximum size is 100_000
    }

    public MyArray(int... a) {
        int dataSize = (a == null) ? 0 : Math.min(a.length, MAX_SIZE);
        data = new int[MAX_SIZE];
        for (int i = 0; i < dataSize; i++) {
            data[i] = a[i];
        }
        size = dataSize;
    }

    public int add(int d) {
        if (isFull()) {
            expand();
        }
        data[size] = d;
        size++;
        return 0;
    }

    public int insert(int d, int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        if (size < MAX_SIZE) {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = d;
            size++;
            return 0;
        }
        return -1;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d)
                return m;
            if (d < data[m])
                b = m - 1;
            else
                a = m + 1; // d > data[m]
        }
        return -1;
    }

    int[] expandByK(int k) {
        int[] temp = new int[MAX_SIZE * k];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        MAX_SIZE *= k;
        data = temp;
        return data;
    }

    int[] expand() {
        return expandByK(2);
    }

    public void delete(int index) {
        if (isEmpty() || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
