package edu.project.service.collection;

import java.util.Scanner;

/**
 * Класс для создания нового билета.
 */
public class TicketBuilder {
    private final Scanner userScanner;

    public TicketBuilder(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * Запрашивает у пользователя все поля, необходимые для создания Ticket
     *
     * @return массив строк: [name, coordX, coordY, price, discount,
     *         TicketType, minAge, ticketCount, EventType, description]
     */
    public String[] buildRecord() {
        System.out.println("===== Конструктор билетов =====");
        System.out.println("Введите название мероприятия: ");
        String name = userScanner.nextLine();

        System.out.println("Координаты X Y мероприятия:");
        String line = userScanner.nextLine().trim();
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            System.out.println("[ERR]: нужно ввести два числа через пробел");
            return null;
        }

        // По условиям задачи x - Integer, y - Float.
        Integer x;
        Float y;
        try {
            x = Integer.parseInt(parts[0]);
            y = Float.parseFloat(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("[ERR]: неверный формат координат");
            return null;
        }

        System.out.println("Введите цену в рублях (без копеек): ");
        Integer price;
        try {
            price = userScanner.nextInt();
        } catch (Exception e) {
            System.out.println("[ERR]: неверный формат цены");
            return null;
        }
        userScanner.nextLine(); // очистка буфера

        System.out.println("Введите скидку (без скидки: 0): ");
        Double discount;
        try {
            discount = userScanner.nextDouble();
        } catch (Exception e) {
            System.out.println("[ERR]: неверный формат скидки");
            return null;
        }
        userScanner.nextLine(); // очистка буфера

        TicketType type;
        System.out.println("Введите тип билета (USUAL, BUDGETARY, CHEAP): ");
        String typeInput = userScanner.nextLine().trim().toLowerCase();
        switch (typeInput) {
            case "u":
            case "usual":
                type = TicketType.USUAL;
                break;
            case "b":
            case "budgetary":
                type = TicketType.BUDGETARY;
                break;
            case "c":
            case "cheap":
                type = TicketType.CHEAP;
                break;
            default:
                System.out.println("Неверный тип, установлен тип USUAL");
                type = TicketType.USUAL;
                break;
        }

        System.out.println("Введите минимальный возраст для участника мероприятия: ");
        int minAge;
        try {
            minAge = userScanner.nextInt();
        } catch (Exception e) {
            System.out.println("[ERR]: неверный формат возраста");
            return null;
        }
        userScanner.nextLine(); // очистка буфера

        System.out.println("Введите количество билетов для мероприятия: ");
        Long ticketCount;
        try {
            ticketCount = userScanner.nextLong();
        } catch (Exception e) {
            System.out.println("[ERR]: неверный формат количества билетов");
            return null;
        }
        userScanner.nextLine(); // очистка буфера

        System.out.println("Введите описание для мероприятия: ");
        String eventDescription = userScanner.nextLine();

        EventType eventType;
        System.out.println("Введите тип мероприятия (CONCERT, E_SPORTS, FOOTBALL): ");
        String eventTypeInput = userScanner.nextLine().trim();
        switch (eventTypeInput) {
            case "c":
            case "concert":
                eventType = EventType.CONCERT;
                break;
            case "e":
            case "e_sports":
                eventType = EventType.E_SPORTS;
                break;
            case "f":
            case "football":
                eventType = EventType.FOOTBALL;
                break;
            default:
                System.out.println("Неверный тип, установлен тип CONCERT");
                eventType = EventType.CONCERT;
                break;
        }

        // Формируем массив в порядке
        return new String[]{
                name,
                String.valueOf(x),
                String.valueOf(y),
                String.valueOf(price),
                String.valueOf(discount),
                type.name(),
                String.valueOf(minAge),
                String.valueOf(ticketCount),
                eventType.name(),
                eventDescription
        };
    }
}