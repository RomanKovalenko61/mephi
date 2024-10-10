package JavaBasic.lesson2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        boolean isResult = true;

        System.out.println("Введите первое число. Например: 10 или 22,4");
        double operand1 = sc.nextDouble();

        System.out.println("Введите знак действия. Например: + - * /");
        char operator = sc.next().charAt(0);

        System.out.println("Введите второе число. Например: 2,5 или 11");
        double operand2 = sc.nextDouble();

        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case '*':
                result = multiply(operand1, operand2);
                break;
            case '/':
                if (operand2 != 0) {
                    result = divide(operand1, operand2);
                } else {
                    isResult = false;
                    System.out.println("Ошибка! на 0 делить  нельзя!");
                }
                break;
            default:
                isResult = false;
                System.out.println("Извините, я не понял какое действие надо выполнить");
                System.out.println("Попробуйте запустить программу еще раз");
                break;
        }
        if (isResult) {
            DecimalFormat format = new DecimalFormat("0.####");
            System.out.printf("Результат операции: %s %s %s = %s ",
                    format.format(operand1), operator, format.format(operand2), format.format(result));
        }

        sc.close();
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }
}
