import java.util.Scanner;

/* Написать программу на любом языке программирования, которая на
вход получает набор из 7 цифр «0» и «1», записанных подряд,
анализирует это сообщение на основе классического кода Хэмминга (7,4),
а затем выдает правильное сообщение (только информационные
биты) и указывает бит с ошибкой при его наличии. */

class Lab2 {

    static byte[] byteTranlate(String message, int length) {
        /* Метод переводящий строку в массив байтов 0 и 1 */
        byte[] byte_message = new byte[length];
        for (int i = 0; i < length; i++) {
            byte_message[i] = (byte) (message.charAt(i) - '0');
        }

        return byte_message;
    }

    static int findControlPoints(int length){
        /* Метод, находящий количество контрольных битов в сообщении */
        int degree = 0;
        while (Math.pow(2, degree) < length) {
            degree++;
        }

        return degree;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user_message = scanner.nextLine();

        // Получаем массив байтов из строки, которую ввёл пользователь
        byte length = 7; //по условиям задачи длина сообщения 7
        byte[] byte_message = byteTranlate(user_message, length);




        for (int i = 0; i < 7; i++) {
            System.out.print(byte_message[i]);
        }

    }
}