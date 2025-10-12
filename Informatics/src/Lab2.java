import java.util.Scanner;

/* Написать программу на любом языке программирования, которая на
вход получает набор из 7 цифр «0» и «1», записанных подряд,
анализирует это сообщение на основе классического кода Хэмминга (7,4),
а затем выдает правильное сообщение (только информационные
биты) и указывает бит с ошибкой при его наличии. */

class Lab2 {

    static byte[] byteTranlate(String message, int length) {
        /* Метод переводящий строку в массив байтов
           сообщение в массиве байтов обрабатывается быстрее,
           а также экономнее потребляет память */
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


    static boolean isBroken(byte[] message){
        /* Метод, проверяющий сломано ли сообщение по коду хэмминга */
        int controlPoints = findControlPoints(message.length);

        for (int i = 0; i < controlPoints; i++) {
            // делаем битовый сдвиг для ^2
            int controlBitPosition = (1 << i);
            int sum = 0;

            for (int j = 0; j < message.length; j++) {
                int bitPosition = j + 1;
                if ((bitPosition & controlBitPosition) != 0) {
                    sum ^= message[j];
                }
            }

            if (sum != 0) {
                return true;
            }
        }

        return false;
    }


    static byte[] repairMessage(byte[] message){


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user_message = scanner.nextLine();

        // Получаем массив байтов из строки, которую ввёл пользователь
        byte[] byte_message = byteTranlate(user_message, user_message.length());


        //Проверяем есть ли ошибка в сообщении, если да - чиним
        if (isBroken(byte_message)) {
            byte_message = repairMessage(byte_message);
        }

        // Вывод
        for (int i = 0; i < 7; i++) {
            System.out.print(byte_message[i]);
        }
    }
}