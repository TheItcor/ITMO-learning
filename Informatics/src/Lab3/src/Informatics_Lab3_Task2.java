// Author = None None None
// Group = None
// Date = 27.10.2025

/*
2:
Студент Вася очень любит курс «Компьютерная безопасность». Однажды Васе
задали домашнее задание зашифровать данные, переданные в сообщении. Недолго
думая, Вася решил заменить все целые числа на функцию от этого числа. Функцию
он придумал не сложную 5x^3−13 , где x −исходное число . Помогите Васе с его
домашним заданием.
Предусмотреть ситуацию, когда в тексте будут не только целые числа, но и любые
символы.
 */

/* TO DO
1. метод, который получает строку и находит все числа
и засовывает их в массив

2. метод, который принимает массив, шифрует, отдаёт зашифрованный массив

3. метод, который получает изначальную строку и зашифрованный массив и объединяет их
а затем отдаёт уже зашифрованную строку.
 */


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Informatics_Lab3_Task2 {

    static ArrayList <Integer> getNumbers(String message) {
        // Метод, получающий строку и достаёт из него числа в массив
        ArrayList <Integer> arrayNumbers = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(message);

        while (matcher.find()) {
            arrayNumbers.add(Integer.parseInt(matcher.group()));
        }

        return arrayNumbers;
    }

    static ArrayList<Integer> cryptNumbers(ArrayList<Integer> arrayNumbers) {
        // Метод, получающий массив чисел, который заменяет числа на функцию от числа
        // возвращает массив чисел от функции
        ArrayList<Integer> cryptNumbers = new ArrayList<>();

        for (int number : arrayNumbers) {
            // Добавляем в динамический массив число от функции по очереди.
            cryptNumbers.add((int) (Math.pow(number, 3) - 13));
        }

        return cryptNumbers;
    }

    public static void main(String[] args) {
        String test1 = "15 + 22 = 37";

        String[] tests = {test1};

        for (String message : tests) {
            System.out.println(cryptNumbers(getNumbers(message)));
        }

    }
}
