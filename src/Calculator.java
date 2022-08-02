import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replace(" ", "");
        str = str.toUpperCase();
        String operator = getOperator(str);
        String[] arguments = getStringArguments(str, operator);
        try {
            System.out.println(result(arguments, operator));
        } catch (Exception e) {
            System.out.println("Результат вывести не удалось :)");
        }
    }

    public static String[] getStringArguments(String str, String operator) {
        String[] arguments = new String[0];
        try {
            arguments = str.split("\\" + operator);
        } catch (Exception e) {
            System.out.println("Аргументы найти не удалось");
        }
        return arguments;
    }

    public static int getIntArgument (String arguments) {
        Integer operand = null;
        try {
            operand = Integer.valueOf(arguments);
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
        }
        if (0 > operand || operand > 10) {
            operand = null;
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Аргументы должны находится в промежутке от 0 до 10 включительно");
            }
        }
        return operand;
    }

    public static String getOperator(String str) {
        String operator = "";
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
        if (operator == "") {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Математическая операция не найдена");
            }
        }
        return operator;
    }

    public static boolean checkRome (String argument) {
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (argument == rome[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int result (String[] arguments, String operator) {
        int result = 0;
        boolean flagFirst = checkRome(arguments[0]);
        boolean flagSecond = checkRome(arguments[1]);
        if (flagFirst && flagSecond) {

        }
        int firstOperand = getIntArgument(arguments[0]);
        int secondOperand = getIntArgument(arguments[1]);
        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "-": result = firstOperand - secondOperand; break;
            case "*": result = firstOperand * secondOperand; break;
            case "/": result = firstOperand / secondOperand; break;
        }
        return result;
    }
}