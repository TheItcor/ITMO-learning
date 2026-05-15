import java.util.Scanner;

class Lab1 {
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
        return i - 1; // предыдущий индекс
    }


    static void translationNumber(int number) {
        /* Перевод из десятичной системы счисления в систему Фибоначчи*/
        int bigFib = searchBigFib(number) ;

        for (; bigFib > 1; bigFib--) {

            // Test
            //System.out.println("F" + bigFib + " = " + fibonacciNumber(bigFib) + " ? " + number);

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
//        // Tests
//        System.out.println("F1 = " + fibonacciNumber(1));
//        System.out.println("F2 = " + fibonacciNumber(2));
//        System.out.println("F3 = " + fibonacciNumber(3));
//        System.out.println("F7 = " + fibonacciNumber(7));
//        System.out.println("F8 = " + fibonacciNumber(8));
//        System.out.println("F9 = " + fibonacciNumber(9));
//        System.out.println();
//
//        // Tests
//        System.out.println(searchBigFib(25)); // 7
//        System.out.println(searchBigFib(65)); // 9
//        System.out.println(searchBigFib(7)); // 4
//        System.out.println();
//
//        // Tests
//        translationNumber(25);  // 1000101
//        translationNumber(65);  // 100010010
//        translationNumber(4);   // 101
//        translationNumber(6);   // 1001
//        translationNumber(10);  // 10010
//        translationNumber(99);  // 1000010010
//        translationNumber(31);  // 1010010

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        translationNumber(number);
    }
}