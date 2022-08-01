import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replace(" ", "");
        str = str.toUpperCase();
        String operator = getOperator(str);
        String[] str1 = str.split("\\" + operator);
        System.out.println(result(str1, operator));
    }

    public static String getOperator(String str) {
        String operator = null;
        boolean plus = str.contains("+");
        boolean minus = str.contains("-");
        boolean multi = str.contains("*");
        boolean devi = str.contains("/");
        if (plus) {
            operator = "+";
        } else if (minus) {
            operator = "-";
        } else if (multi) {
            operator = "*";
        } else if (devi) {
            operator = "/";
        }
        return operator;
    }

    public static int result (String[] str1, String operator) {
        int result = 0;
        Integer firstOperand = Integer.valueOf(str1[0]);
        Integer secondOperand = Integer.valueOf(str1[1]);

        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "-": result = firstOperand - secondOperand; break;
            case "*": result = firstOperand * secondOperand; break;
            case "/": result = firstOperand / secondOperand; break;
        }
        return result;
    }
}