// Author = TheItcor (Itcor)
// Group = XXXXX
// Date = 27.10.2025

/*
1:
Вам необходимо поменять падежи в тексте у прилагательных, которые встречаются
несколько раз. На вход подаётся текст и порядковый номер слова, падежная форма
которого будет использована для замены.
Пример ввода:
1)Номер 2
2)Текст:
Футбольный клуб «Реал Мадрид» является 15-кратным обладателем главного
футбольного европейского трофея – Лиги Чемпионов. Данный турнир организован
Союзом европейских футбольных ассоциаций (УЕФА). Идея о континентальном
футбольном турнире пришла к журналисту Габриэлю Ано в 1955 году.
 */

import java.util.*;
import java.util.regex.*;

public class Informatics_Lab3_Task3 {
    public static final String[] ends = {"ого","ему","ому","ыми","ими","ых","их","ая","ое","ые","ий","ый","ой","ым","им"};

    static String getStem(String w) {
        // Метод для получения основы слова (без окончания)
        String lw = w.toLowerCase();
        for (String e : ends)
            if (lw.endsWith(e))
                return lw.substring(0, lw.length() - e.length());

        // без окончания - возращаем слово как есть
        return lw;
    }

    static String getEnding(String w) {
        // Метод для получения окончания слова
        String lw = w.toLowerCase();
        for (String e : ends)
            if (lw.endsWith(e))
                return e;

        // ничего не возращаем, если нет окончания
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        // Ввод номера слова и текста
        int index = Integer.parseInt(sc.nextLine().trim()) +1;
        String text = sc.useDelimiter("\\Z").next();
        sc.close();

        // Ищем прилагательные
        Pattern p = Pattern.compile("(?U)\\b[А-Яа-яЁё]+?(?:ый|ий|ой|ая|ое|ые|ого|ему|ому|ым|им|ых|их)\\b");
        Matcher m = p.matcher(text);

        // Для хранения прилагательных динамический массив:
        List<String> adjs = new ArrayList<>();
        while (m.find()) adjs.add(m.group()); // ищем прилагательные и добавляем в список

        if (adjs.isEmpty() || index < 1 || index > adjs.size()) {
            // Проверяем есть ли прилагательные в массиве, если нет, то вывод изначального текста
            System.out.println(text);
            return;
        }

        // получаем выбранное прилагательное и его окончание
        String chosen = adjs.get(index - 1);
        String chosenEnding = getEnding(chosen);

        // Если нет окончаний: выводим изначальных текст
        if (chosenEnding.isEmpty()) {
            System.out.println(text);
            return;
        }

        String result = text; // копия текста
        // Подсчёт встречаемости основы слова
        Map<String, Integer> freq = new HashMap<>();

        // Подсчёт основы
        for (String a : adjs) {
            String stem = getStem(a);
            freq.put(stem, freq.getOrDefault(stem, 0) + 1);
        }

        // Замена окончаний
        for (String a : adjs) {
            String stem = getStem(a);
            if (freq.get(stem) > 1) {
                // Слово-заменитель из основы и окончания
                String replacement = stem + chosenEnding;

                // Сохранение регистра первой буквы
                if (Character.isUpperCase(a.charAt(0)))
                    replacement = replacement.substring(0, 1).toUpperCase() + replacement.substring(1);
                // Заменяем все вхождения этого прилагательного в тексте
                result = result.replaceAll("(?U)\\b" + Pattern.quote(a) + "\\b", replacement);
            }
        }
        System.out.println(result);
    }
}