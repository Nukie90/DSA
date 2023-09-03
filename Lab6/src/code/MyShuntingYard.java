package code;

import java.util.StringTokenizer;

public class MyShuntingYard {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infixString) {
        System.out.println("infixString = " + infixString);
        MyQueueL queue = new MyQueueL();
        MyStackL stack = new MyStackL();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            System.out.println("current t = " + t);
            if (MyRPN.isNumeric(t))
                queue.enqueue(t);
            else if (t.equals("(")) {

                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.top().equals("(")) {
                    queue.enqueue(String.valueOf(stack.pop()));
                }
                stack.pop(); // discard "("
            } else {
                if (!stack.isEmpty()) { // double lovely bug
                    while (order(t) <= order(stack.top())) {
                        queue.enqueue(String.valueOf(stack.pop()));
                        if (stack.isEmpty())
                            break;
                    }

                }
                stack.push(t);

                /* your code */
            }
            System.out.println("current q = " + queue.dumpToString());
            System.out.println("current s = " + stack);
            System.out.println("");
        }
        while (!stack.isEmpty()) {
            queue.enqueue(String.valueOf(stack.pop()));
        }
        /* your code */
        System.out.println("queue = " + queue);
        resultPostfixString = queue.dumpToString();
        return resultPostfixString; // "happy coding";
    }
}