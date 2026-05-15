package edu.project.service.fileio;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import edu.project.service.collection.*;

/**
 * Читает .csv файл и возвращает сырые строки в виде массивов строк.
 * Использует внешнюю библиотеку OpenCSV для парса
 */
public class CsvParser {

    /**
     * Читает все строки .csv файла полностью
     *
     * @param filePath путь к файлу
     * @return список массивов строк, где каждый массив соответствует полям одной строки .csv
     * @throws IOException если произошла ошибка ввода-вывода
     */
    public List<String[]> readCsvFile(String filePath) throws IOException, CsvValidationException {
        // Парсим:
        // String name
        // Integer CoordinateX
        // Float CoordinateY
        // Integer price
        // Double discount
        // TicketType TicketType
        // int minAge
        // Long ticketCount
        // EventType EventType
        // String description

        List<String[]> rows = new ArrayList<>();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
             InputStreamReader isr = new InputStreamReader(bis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr);
             CSVReader csvReader = new CSVReader(br)) {


            String[] record;

            // Читаем пока не закончится .csv файл
            while ((record = csvReader.readNext()) != null) {
                rows.add(record);
            }
        }
        return rows;
    }
}