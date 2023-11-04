import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int[] arr = { 64, 56, 48, 32, 88, 42 };
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // countingSort(arr);
        // quickSort(arr, 0, arr.length - 1);
        // mergeSort(arr, 0, arr.length - 1);
        // radixSort(arr);
        // bucketSort(arr);
        shellSort(arr);
        // heapSort(arr);
        System.out.println("Sorted array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // n-1 because last element will be sorted automatically
            int min = i;
            for (int j = i + 1; j < n; j++) { // j=i+1 because we have to compare with next element
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) { // i=1 because first element is already sorted
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { // j>=0 because we have to compare with previous element
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) { // i=1 because first element is already sorted
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        System.out.println(count.length);
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < max + 1; i++) {
            while (count[i] > 0) {
                arr[k] = i;
                k++;
                count[i]--;
            }
        }
    }

    public static int pivot(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) { // j=low because we have to compare with next element
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = pivot(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);

        }
    }

    public static void countingByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) { // i=1 because first element is already sorted
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingByDigit(arr, exp);
        }
    }

    private static void insertionSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) { // i=1 because first element is already sorted
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) { // j>=0 because we have to compare with previous element
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
            for (int k = 0; k < arr.size(); k++) {
                System.out.print(arr.get(k) + " ");
            }
            System.out.println();
        }
    }

    public static void bucketSort(int[] arr) {
        int n = arr.length;

        double max = arr[0];
        double min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int numBucket = n;
        List[] buckets = new List[numBucket];

        for (int i = 0; i < numBucket; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] - min) * (numBucket - 1) / (max - min));
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < numBucket; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < numBucket; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = (int) buckets[i].get(j);
                index++;
            }
        }

    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) { // i=gap because first element is already sorted
                int key = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > key) { // j>=0 because we have to compare with previous element
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = key;
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // if right child is larger than root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // if largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        // extract element from heap
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

}
