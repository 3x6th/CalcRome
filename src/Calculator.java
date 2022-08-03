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
            arguments = str.split(new StringBuilder().append("\\").append(operator).toString());
        } catch (Exception e) {
            System.out.println("Аргументы найти не удалось");
        }
        int len = arguments.length;
        if (len > 2) {
            arguments = new String[0];
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        return arguments;
    }

    public static int getIntArgument (String argument) {
        Integer operand = null;
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
        return operand;
    }

    public static String getOperator(String str) {
        String operator = "";
        int count = 0;
        boolean plus = str.contains("+");
        boolean minus = str.contains("-");
        boolean multi = str.contains("*");
        boolean devi = str.contains("/");
        if (plus) {
            operator = "+";
            count += 1;
        }
        if (minus) {
            operator = "-";
            count += 1;
        }
        if (multi) {
            operator = "*";
            count += 1;
        }
        if (devi) {
            operator = "/";
            count += 1;
        }
        if (operator.equals("")) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Строка не является математической операцией");
            }
        }
        if (count > 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        return operator;
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

    public static String encoder (int result) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romes = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romeResult = "";

        for (int i = 0; i < 9; i++) {
            while (result >= values[i]) {
                result -= values[i];
                romeResult = romeResult.concat(romes[i]);
            }
        }
        return romeResult;
    }

    public static int result (String[] arguments, String operator) {
        int result = 0;
        int flagFirst = decoder(arguments[0]);
        int flagSecond = decoder(arguments[1]);
        int firstOperand = -1;
        int secondOperand = -1;
        if (flagFirst > 0 && flagSecond > 0) {
            firstOperand = decoder(arguments[0]);
            secondOperand = decoder(arguments[1]);
        } else if (flagFirst > 0 && getIntArgument(arguments[1]) > -1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("используются одновременно разные системы счисления");
            }
        } else if (flagSecond > 0 && getIntArgument(arguments[0]) > -1){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("используются одновременно разные системы счисления");
            }
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
        System.out.println(encoder(result));
        return result;
    }
}