// Author = TheItcor (Itcor)
// Group = XXXXX
// Date = 27.10.2025

/*
2:
Студент Вася очень любит курс «Компьютерная безопасность». Однажды Васе
задали домашнее задание зашифровать данные, переданные в сообщении. Недолго
думая, Вася решил заменить все целые числа на функцию от этого числа. Функцию
он придумал не сложную 5x^3−13, где x −исходное число. Помогите Васе с его
домашним заданием.
Предусмотреть ситуацию, когда в тексте будут не только целые числа, но и любые
символы.
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

    static String replaceNumbers(String message, ArrayList<Integer> arrayNumbers) {
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(message);

        int index = 0;
        StringBuffer result = new StringBuffer();

        while (matcher.find() && index < arrayNumbers.size()) {
            matcher.appendReplacement(result, String.valueOf(arrayNumbers.get(index)));
            index++;
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        String test1 = "15 + 22 = 37";
        String test2 = "6a * 9b = x";

        String[] tests = {test1, test2};

        for (String message : tests) {
            ArrayList<Integer> newNumbers = cryptNumbers(getNumbers(message));
            System.out.println(replaceNumbers(message, newNumbers));
        }

    }
}
