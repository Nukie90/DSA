public class Resursion {
    public static void main(String[] args) throws Exception {
        System.out.println(factorial(5));
        System.out.println(fibonacci(5));
        System.out.println(fibMem(5, new int[6]));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibMem(int n, int[] mem){
        if (n == 0 || n == 1) {
            return 1;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        mem[n] = fibMem(n-1, mem) + fibMem(n-2, mem);
        return mem[n];
    }
}
