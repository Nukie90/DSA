package code;
public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int[] data;
    protected int size = 0;
    public void add(int d) {
        data[size]=d;
        size=size+1;
    }
    public void insert(int d, int index) {
        data[size++]=data[index];
        data[index] = d;
    }
    public int find(int d) {
        int index=-1;
        for(int i=0; i<size; i++) {
            if(data[i]==d) {
            index = i;
            break;
            }
        }
        return index;
    }
    public int binarySearch(int d) {
        int a = 0, b=size-1;
        while(a<=b) {
            int m = (a+b)/2;
            if(data[m]==d) return m;
            if(d<data[m]) b = m-1;
            else a = m+1; // d>data[m]
        }
        return -1;
    }
    public void delete(int index) {
        data[index] = data[--size];
    }
    public MyArrayBasic(int... a) {
        int dataSize = (a == null) ? 0 : Math.min(a.length, MAX_SIZE);
        data = new int[MAX_SIZE];
        for (int i = 0; i < dataSize; i++) {
            data[i] = a[i];
        }
        size = dataSize; // Set the correct size of the array
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
