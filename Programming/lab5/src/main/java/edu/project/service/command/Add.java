package edu.project.service.command;

import edu.project.service.collection.*;

import java.util.Scanner;

public class Add extends Command {
    private static final String name = "add";
    private static final String description = "add {element} : добавить новый элемент в коллекцию";
    private static final boolean hasOperand = true;
    private final CollectionManager collectionManager;
    private final Scanner userScanner;



    /**
     * Вызывает конструктор и добавляет созданный билет в коллекцию.
     *
     */
    @Override
    boolean execute() {

        System.out.println("===== Конструктор билетов =====");
        System.out.println("Введите название мероприятия: ");
        String name = userScanner.nextLine();

        System.out.println("Координаты X Y мероприятия:");
        String line = userScanner.nextLine().trim();
        String[] parts = line.split("\\s+"); // разбиваем по пробелам

        if (parts.length < 2) {
            System.out.println("[ERR]: нужно ввести два числа через пробел");
            return false;
        }

        // По условиям задачи x - Integer, y - Float. Преобразуем, чтобы не было ошибок
        Integer x = (int) Integer.parseInt(parts[0]);
        Float y = (float) Integer.parseInt(parts[1]);

        System.out.println("Введите цену в рублях (без копеек): ");
        Integer price = userScanner.nextInt();

        System.out.println("Введите скидку (без скидки: 0): ");
        Double discount = userScanner.nextDouble();
        userScanner.nextLine();

        TicketType type;
        System.out.println("Введите тип билета (стандарт, бюджетный, дешёвый): ");
        String typeInput = userScanner.nextLine().trim();
        switch (typeInput) {
            case "с":
            case "стан":
            case "стандартный":
                type = TicketType.USUAL;
                break;
            case "б":
            case "бюд":
            case "бюджетный":
                type = TicketType.BUDGETARY;
                break;
            case "д":
            case "деш":
            case "дешёвый":
                type = TicketType.CHEAP;
                break;
            default:
                System.out.println("Неверный тип, установлен тип Стандартный");
                type = TicketType.USUAL;
                break;
        }

        // Создаём координаты
        Coordinates coordinates = new Coordinates(x, y);

        System.out.println("Введите минимальный возраст для участника мероприятия: ");
        int minAge = userScanner.nextInt();

        System.out.println("Введите количество билетов для мероприятия: ");
        Long ticketCount = userScanner.nextLong();

        System.out.println("Введите описание для мероприятия: ");
        String eventDescription = userScanner.nextLine();

        EventType eventType;
        System.out.println("Введите тип мероприятия (концерт, киберспорт, футбол): ");
        String eventTypeInput = userScanner.nextLine().trim();
        switch (eventTypeInput) {
            case "ко":
            case "кон":
            case "концерт":
                eventType = EventType.CONCERT;
                break;
            case "ки":
            case "кибер":
            case "киберспорт":
                eventType = EventType.E_SPORTS;
                break;
            case "ф":
            case "фут":
            case "футбол":
                eventType = EventType.FOOTBALL;;
                break;
            default:
                System.out.println("Неверный тип, установлен тип Концерт");
                eventType = EventType.CONCERT;
                break;
        }

        // String name, int minAge, Long ticketsCount, String description, EventType eventType
        Event newEvent = new Event(name, minAge, ticketCount, eventDescription, eventType);

        //String name, Coordinates coordinates, Integer price, Double discount, TicketType type, Event event
        Ticket newTicket = new Ticket(name, coordinates, price, discount, type, newEvent);

        collectionManager.addTicket(newTicket);
        System.out.println("===== Билет успешно добавлен в коллекцию. =====");
        return true;
    }

    public Add(CollectionManager collectionManager, Scanner userScanner){
        super(name, description, hasOperand);
        this.collectionManager = collectionManager;
        this.userScanner = userScanner;

    }
}