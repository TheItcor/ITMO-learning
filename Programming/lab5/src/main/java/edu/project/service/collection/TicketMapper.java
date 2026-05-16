package edu.project.service.collection;

import java.io.IOException;

public class TicketMapper {
    /**
     * Получаем поля массивом строк, создаём переменные для создания Ticket
     * В процессе для Ticket вспомогательно создаёт Coordinates, Event.
     * @param record - массив из полей с .csv файла
     * @return Ticket - возвращает новый Ticket
     */
    public static Ticket fromRecord(String[] record) {
        String name = record[0].trim();
        int coordX = Integer.parseInt(record[1].trim());
        float coordY = Float.parseFloat(record[2].trim());
        int price = Integer.parseInt(record[3].trim());
        double discount = Double.parseDouble(record[4].trim());
        TicketType ticketType = TicketType.valueOf(record[5].trim().toUpperCase());
        int minAge = Integer.parseInt(record[6].trim());
        long ticketCount = Long.parseLong(record[7].trim());
        EventType eventType = EventType.valueOf(record[8].trim().toUpperCase());
        String description = record[9].trim();


        Coordinates coordinates = new Coordinates(coordX, coordY);
        Event event = new Event(name, minAge, ticketCount, description, eventType);

        return new Ticket(name, coordinates, price, discount, ticketType, event);
    }
}
