// Author = None None None
// Group = None
// Date = 27.10.2025


/*
0:
В качестве разделителя строк используются символы «/». Если разделители делят текст на
строки, в которых 5/7/5 слогов, то выведите «Хайку!». Если число строк не равно 3,
то выведите строку «Не хайку. Должно быть 3 строки.». Иначе выведите строку вида
«Не хайку.»
* */

class Informatics_Lab3_Task1 {
    static byte isHaiku(String text) {
        // Метод, который анализирует текст и выдаёт ответ от 0 до 2
        // Вывод: 0 - если текст - хайку
        // Вывод: 1 - если текст - не хайку и строк != 3
        // Вывод: 2 - если текст - не хайку по другим причинам

        // Проверка на наличие двух "/" в тексте
        if (!text.matches("([^/]*/){2}[^/]*")){
            return 1;
        }

        // Проверка на слоги
        if (text.matches("")){
            return 2; // ДОДЕЛАТЬ
        }

        return 0;
    }


    public static void main(String[] args) {
        String Test1 = "Вечер за окном. / Еще один день прожит. / Жизнь скоротечна...";
        String Test2 = "Просто текст";
        String Test3 = "Как вишня расцвела! / Она с коня согнала / И князя-гордеца.";

        String[] tests = {Test1, Test2, Test3};

        for (String test : tests) {
            switch (isHaiku(test)) {
                case 0:
                    System.out.println("Хайку!");
                    break;
                case 1:
                    System.out.println("Не хайку. Должно быть 3 строки.");
                    break;
                case 2:
                    System.out.println("Не хайку.");
                    break;
            }
        }
    }
}
