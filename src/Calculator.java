import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.replace(" ", "");
        str = str.toUpperCase();
        String operator = getOperator(str);
        System.out.println("d3");
        String[] arguments = getStringArguments(str, operator);
        System.out.println("d4");
        try {
            System.out.println("d7");
            System.out.println(result(arguments, operator));
        } catch (Exception e) {
            System.out.println("Результат вывести не удалось :)");
        }
    }

    public static String[] getStringArguments(String str, String operator) {
        String[] arguments = new String[0];
        try {
            arguments = str.split(new StringBuilder().append("\\").append(operator).toString());
        } catch (Exception e) {
            System.out.println("Аргументы найти не удалось");
        }
        return arguments;
    }

    public static int getIntArgument (String argument) {
        Integer operand = null;
        System.out.println("d5");
        try {
            operand = Integer.valueOf(argument);
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
        System.out.println("d2");
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
        if (operator.equals("")) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Строка не является математической операцией");
            }
        }
        System.out.println("d1");
        return operator;
    }

    public static int checkRome (String argument) {
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int flag = 0;
        for (int i = 0; i < 11; i++) {
            if (Objects.equals(argument, rome[i])) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public static int decoder (String argument) {
        int value = 0;
        if ("I".equals(argument)) {
            value = 1;
        } else if ("II".equals(argument)) {
            value = 2;
        } else if ("III".equals(argument)) {
            value = 3;
        } else if ("IV".equals(argument)) {
            value = 4;
        } else if ("V".equals(argument)) {
            value = 5;
        } else if ("VI".equals(argument)) {
            value = 6;
        } else if ("VII".equals(argument)) {
            value = 7;
        } else if ("VIII".equals(argument)) {
            value = 8;
        } else if ("IX".equals(argument)) {
            value = 9;
        } else if ("X".equals(argument)) {
            value = 10;
        }
        return value;
    }

    public static int result (String[] arguments, String operator) {
        int result = 0;
        System.out.println("d8");
        int flagFirst = decoder(arguments[0]);
        int flagSecond = decoder(arguments[1]);
        System.out.println("d9");
        int firstOperand;
        int secondOperand;

        if (flagFirst > 0 && flagSecond > 0) {
            firstOperand = decoder(arguments[0]);
            secondOperand = decoder(arguments[1]);
        } else {
            firstOperand = getIntArgument(arguments[0]);
            secondOperand = getIntArgument(arguments[1]);
        }
        switch (operator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> result = firstOperand / secondOperand;
        }
        return result;
    }
}