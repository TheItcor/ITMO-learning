import java.util.Scanner;

class Lab1_forDocs {
    static int fibonacciNumber(int number) {
        /* Поиск числа фибоначчи по индексу*/
        if (number == 1 || number == 2) return 1;
        int a = 1, b = 1, result = 0;
        for (int i = 3; i <= number; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }


    static int searchBigFib(int number) {
        /* Нахождение наибольшего числа*/
        int i = 2;
        while (fibonacciNumber(i) <= number) {
            i++;
        }
        return i - 1;
    }


    static void translationNumber(int number) {
        /* Перевод из десятичной системы счисления в систему Фибоначчи*/
        int bigFib = searchBigFib(number) ;

        for (; bigFib > 1; bigFib--) {
            if (fibonacciNumber(bigFib) > number) {
                System.out.print("0");
            } else {
                number -= fibonacciNumber(bigFib);
                System.out.print("1");
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        translationNumber(number);
    }
}