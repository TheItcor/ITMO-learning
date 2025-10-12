import java.util.Scanner;


class Lab2_forDocs {

    static byte[] byteTranlate(String message, int length) {
        /* Метод переводящий строку в массив байтов */
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

    static int findErrorIndex(byte[] message){
        /* Метод, который находит индекс ошибки и возращает его
           если ошибки нет, то возращает -1 */
        int controlPoints = findControlPoints(message.length);
        int errorAddress = 0;

        for (int i = 0; i < controlPoints; i++) {
            // Побитый сдвиг для возведения в ^2
            int controlBitPosition = (1 << i);
            int sum = 0;

            //отбираем только те биты, которые задаются контрольным битом
            for (int j = 0; j < message.length; j++) {
                int bitPosition = j + 1;
                if ((bitPosition & controlBitPosition) != 0) {
                    sum ^= message[j];
                }
            }

            if (sum != 0) {
                errorAddress |= (1 << i);
            }
        }

        // Если ошибки нет - возращаем -1
        if (errorAddress == 0) {
            return -1;
        }

        // Если ошибка есть - возращает её индекс
        return errorAddress - 1;
    }

    static byte[] repairMessage(byte[] message){
        /* Метод, получающий сообщение с ошибкой.
           !!! Если ошибки нет, будет непредсказуемое поведение
           Возращает исправленное сообщение. */
        int errorIndex = findErrorIndex(message);

        // Исправляем ошибку - инвертируем бит
        if (message[errorIndex] == 0) {
            message[errorIndex] = 1;
        } else {
            message[errorIndex] = 0;
        }

        return message;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user_message = scanner.nextLine();

        // Получаем массив байтов из строки, которую ввёл пользователь
        byte[] byte_message = byteTranlate(user_message, user_message.length());


        //Проверяем есть ли ошибка в сообщении, если да - чиним
        if (findErrorIndex(byte_message) != -1) {
            System.out.println("Найдена ошибка. Индекс Ошибки: " + findErrorIndex(byte_message) + " (Отсчёт с нуля)");
            byte_message = repairMessage(byte_message);
            System.out.print("Исправленный код: ");
        }

        // Вывод
        for (byte bit : byte_message) {
            System.out.print(bit);
        }
    }
}