package code;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        MyStackL stack = new MyStackL();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t))
                stack.push(t);
            else {
                if (t.equals("-")) {
                    String b = stack.pop();
                    int x = Integer.parseInt(b);
                    String a = stack.pop();
                    int y = Integer.parseInt(a);
                    stack.push(String.valueOf(y - x));
                }
                else if (t.equals("+")) {
                    String b = stack.pop();
                    int x = Integer.parseInt(b);
                    String a = stack.pop();
                    int y = Integer.parseInt(a);
                    stack.push(String.valueOf(y + x));
                }
                else if (t.equals("/")) {
                    String b = stack.pop();
                    int x = Integer.parseInt(b);
                    String a = stack.pop();
                    int y = Integer.parseInt(a);
                    stack.push(String.valueOf(y / x));
                }
                else if (t.equals("*")) {
                    String b = stack.pop();
                    int x = Integer.parseInt(b);
                    String a = stack.pop();
                    int y = Integer.parseInt(a);
                    stack.push(String.valueOf(y * x));
                }

            }
        }
        return Integer.parseInt(stack.pop());
    }

    /* your code */
}