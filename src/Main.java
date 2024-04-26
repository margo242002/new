import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение (например, 1 + 2): ");
        String str = scanner.nextLine();
        String[] parts = str.split(" ");

        if (parts.length != 3) {
            try {
                throw new InvalidInputFormatException();
            } catch (InvalidInputFormatException e) {
                System.out.println("Неверный формат ввода");
            }
            return;
        }
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        String operator = parts[1];
        int result;

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            try {
                throw new OutOfRangeException();
            } catch (OutOfRangeException e) {
                System.out.println("Числа должны быть от 1 до 10");
            }
            return;
        }

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                try {
                    throw new InvalidOperatorException();
                } catch (InvalidOperatorException e) {
                    System.out.println("Неверный оператор");
                }
                return;
        }

        System.out.println("Результат: " + result);
    }
    static class InvalidInputFormatException extends Exception {
        public InvalidInputFormatException() { }
    }

    static class OutOfRangeException extends Exception {
        public OutOfRangeException() { }
    }

    static class InvalidOperatorException extends Exception {
        public InvalidOperatorException() { }
    }
}