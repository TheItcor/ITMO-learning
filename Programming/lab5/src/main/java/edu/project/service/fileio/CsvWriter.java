package edu.project.service.fileio;

import edu.project.service.collection.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class CsvWriter {

    /**
     * Записывает коллекцию билетов в csv-файл построчно
     *
     * @param tickets  множество билетов для сохранения
     * @param filePath путь к файлу
     * @throws IOException если произошла ошибка чтения
     */
    public void writeTickets(Set<Ticket> tickets, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(filePath),
                        StandardCharsets.UTF_8))) {

            for (Ticket t : tickets) {
                String line = ticketToCsvLine(t);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Преобразует билет в строку CSV с экранированием.
     * Порядок полей соответствует тому, который ожидает CsvParser / TicketMapper.
     */
    private String ticketToCsvLine(Ticket t) {
        return String.join(",",
                escapeCsv(t.getName()),                                     // 0: name
                escapeCsv(String.valueOf(t.getCoordinates().getX())),       // 1: coordX (Integer)
                escapeCsv(String.valueOf(t.getCoordinates().getY())),       // 2: coordY (Float)
                escapeCsv(String.valueOf(t.getPrice())),                    // 3: price (Integer)
                escapeCsv(String.valueOf(t.getDiscount())),                 // 4: discount (Double)
                escapeCsv(t.getType().name()),                              // 5: TicketType
                escapeCsv(String.valueOf(t.getEvent().getMinAge())),        // 6: minAge (int)
                escapeCsv(String.valueOf(t.getEvent().getTicketsCount())),  // 7: ticketCount (Long)
                escapeCsv(t.getEvent().getEventType().name()),              // 8: EventType
                escapeCsv(t.getEvent().getDescription())                    // 9: description
        );
    }

    /**
     * Заключает строку в двойные кавычки и дублирует внутренние кавычки,
     * если она содержит запятую, кавычку или символ перевода строки.
     * Иначе возвращает как есть.
     */
    private String escapeCsv(String field) {
        if (field == null) return "";
        if (field.contains(",") || field.contains("\"") || field.contains("\n") || field.contains("\r")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }
}