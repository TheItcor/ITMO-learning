class Lab1 {
    static int fibonacciNumber(int number) {
        /* Число фибоначи по номеру*/
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
        int i = 2;
        while (fibonacciNumber(i) <= number) {
            i++;
        }

        // возращение предудущего числа
        return i - 1;
    }


    static void translationNumber(int number) {
        int bigFib = searchBigFib(number);

        boolean wasOne = false; // чтобы не было двух единиц подряд
        for (int i = bigFib; i >= 2; i--) {
            int f = fibonacciNumber(i);
            if (f <= number && !wasOne) {
                System.out.print("1");
                number -= f;
                wasOne = true;
            } else {
                System.out.print("0");
                wasOne = false;
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {

        // Tests
        System.out.println("F1 = " + fibonacciNumber(1));
        System.out.println("F2 = " + fibonacciNumber(2));
        System.out.println("F3 = " + fibonacciNumber(3));
        System.out.println("F7 = " + fibonacciNumber(7));
        System.out.println("F8 = " + fibonacciNumber(8));
        System.out.println("F9 = " + fibonacciNumber(9));
        System.out.println();

        // Tests
        System.out.println(searchBigFib(25)); // 7
        System.out.println(searchBigFib(65)); // 9
        System.out.println(searchBigFib(7)); // 4
        System.out.println();

        // Tests
        translationNumber(25);  // 1000101
        translationNumber(65);  // 10010010
        translationNumber(4);   // 101
        translationNumber(6);   // 1001
        translationNumber(10);  // 10010
        translationNumber(99);  // 1000010010
        translationNumber(31);  // 1010010

    }
}