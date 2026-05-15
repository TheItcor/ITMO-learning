package edu.project.service.collection;


import com.opencsv.exceptions.CsvValidationException;
import edu.project.service.fileio.CsvParser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class TicketCollectionBuilder {

    /**
     * Метод для создания сет Ticket'ов по полям из .csv файла
     * @param filePath - путь к .csv файлу
     * @return tickets - HashSet из Ticket
     */
    public Set<Ticket> build(String filePath) throws IOException, CsvValidationException {

        // Сет с Ticket на возврат
        Set<Ticket> tickets = new HashSet<>();

        // Проходимся по файлу, парсим, создаём Ticket, засовываем в HashSet
        for (String[] record : new CsvParser().readCsvFile(filePath)) {
            tickets.add(TicketMapper.fromCsvRecord(record));
        }
        return tickets;
    }
}
