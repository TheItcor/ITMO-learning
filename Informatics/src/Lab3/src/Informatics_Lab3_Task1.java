// Author = TheItcor (Itcor)
// Group = XXXXX
// Date = 27.10.2025


/*
0:
В качестве разделителя строк используются символы «/». Если разделители делят текст на
строки, в которых 5/7/5 слогов, то выведите «Хайку!». Если число строк не равно 3,
то выведите строку «Не хайку. Должно быть 3 строки.». Иначе выведите строку вида
«Не хайку.»
* */

class Informatics_Lab3_Task1 {

    static boolean isPattern575(String text){
        // Метод, проверяющий подходит ли массив строк по правилу 5 слог, 7 слог, 5 слог
        int[] pattern575 = {5, 7, 5};
        String[] fragmentedText = text.split("\\s*/\\s*");

        for (int i = 0; i < 3; i++) {
            int count = fragmentedText[i].replaceAll("[^аеёиоуыэюяАЕЁИОУЫЭЮЯ]", "").length();

            if (count != pattern575[i]) {
                return false;
            }
        }

        return true;
    }

    static byte isHaiku(String text) {
        // Метод, который анализирует текст и выдаёт ответ от 0 до 2
        // Вывод: 0 - если текст - хайку
        // Вывод: 1 - если текст - не хайку и строк != 3
        // Вывод: 2 - если текст - не хайку по другим причинам

        // Проверка на наличие двух "/" в тексте
        if (!text.matches("([^/]*/){2}[^/]*")){
            return 1;
        }

        // Проверка на слоги 5-7-5
        if (!isPattern575(text)) {
            return 2;
        }

        return 0;
    }


    public static void main(String[] args) {
        String test1 = "Вечер за окном. / Еще один день прожит. / Жизнь скоротечна...";
        String test2 = "Просто текст";
        String test3 = "Как вишня расцвела! / Она с коня согнала / И князя-гордеца.";
        String test4 = "Ты человек / Он не человек / Они не люди";
        String test5 = "/g/";
        String test6 = "Кто я?";
        String test7 = "Где /";
        String test8 = "Знает лишь время, / Сколько дорог мне пройти, / Чтоб достичь счастья.";
        /*
        1 Хайку!
        2 Не хайку. Должно быть 3 строки.
        3 Не хайку.
        4 Не хайку.
        5 Не хайку.
        6 Не хайку. Должно быть 3 строки.
        7 Не хайку. Должно быть 3 строки.
        8 Хайку!
         */


        String[] tests = {test1, test2, test3, test4, test5, test6, test7, test8};

        int i = 1;
        for (String test : tests) {
            System.out.print(i + " ");
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

            i++;
        }
    }
}
