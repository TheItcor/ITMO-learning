package edu.project.service.command;

import edu.project.service.collection.*;
import java.util.Scanner;


/**
 * Класс для команды update_id {element}
 */
public class UpdateId extends Command{
    private final static String name = "update";
    private final static String description = "update ID {element} : обновить значение элемента коллекции, ID которого равен заданному";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;
    private final Scanner userScanner;


    /**
     * Метод для обновления билета в коллекции по ID.
     */
    @Override
    boolean execute(String ID) {
        Ticket ticket = collManager.findById(ID);
        if (ticket == null) {
            System.out.println("Билет с id=" + ID + " не найден");
            return false;
        }

        System.out.println("===== Обновление билета id=" + ticket.getId() + " =====");
        System.out.println("Оставляйте поле пустым (Enter), чтобы сохранить текущее значение.");


        System.out.print("Введите название: ");
        String name = readLine();
        if (name.isEmpty()) name = ticket.getName();


        System.out.print("Введите координаты X Y: ");
        String coordLine = readLine();
        Coordinates coordinates;
        if (coordLine.isEmpty()) {
            coordinates = ticket.getCoordinates();
        } else {
            String[] parts = coordLine.trim().split("\\s+");
            if (parts.length < 2) {
                System.out.println("[ERR] Неверное количество координат. Оставлены старые координаты.");
                coordinates = ticket.getCoordinates();
            } else {
                try {
                    int x = Integer.parseInt(parts[0]);
                    float y = Float.parseFloat(parts[1]);   // по условию y - Float
                    coordinates = new Coordinates(x, y);
                } catch (NumberFormatException e) {
                    System.out.println("[ERR] Неверный числовой формат. Оставлены старые координаты.");
                    coordinates = ticket.getCoordinates();
                }
            }
        }


        System.out.print("Введите цену в рублях (без копеек): ");
        String priceStr = readLine();
        Integer price;
        if (priceStr.isEmpty()) {
            price = ticket.getPrice();
        } else {
            try {
                price = Integer.parseInt(priceStr);
            } catch (NumberFormatException e) {
                System.out.println("[ERR] Неправильный формат числа. Оставлена старая цена.");
                price = ticket.getPrice();
            }
        }

        System.out.print("Введите скидку (без скидки: 0): ");
        String discountStr = readLine();
        Double discount;
        if (discountStr.isEmpty()) {
            discount = ticket.getDiscount();
        } else {
            try {
                discount = Double.parseDouble(discountStr);
            } catch (NumberFormatException e) {
                System.out.println("[ERR] Неверное число. Оставлена старая скидка.");
                discount = ticket.getDiscount();
            }
        }
        TicketType type;
        System.out.println("Введите тип билета (USUAL, BUDGETARY, CHEAP): ");
        String typeInput = userScanner.nextLine().trim().toLowerCase();
        if (typeInput.isEmpty()) {
            type = ticket.getType();
        } else {
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
        }


        Event oldEvent = ticket.getEvent();
        System.out.print("Введите минимальный возраст: ");
        String minAgeStr = readLine();
        int minAge;
        if (minAgeStr.isEmpty()) {
            minAge = oldEvent.getMinAge();
        } else {
            try {
                minAge = Integer.parseInt(minAgeStr);
            } catch (NumberFormatException e) {
                System.out.println("Неверное число. Оставлено старое значение.");
                minAge = oldEvent.getMinAge();
            }
        }

        System.out.print("Введите количество билетов: ");
        String ticketCountStr = readLine();
        long ticketCount;
        if (ticketCountStr.isEmpty()) {
            ticketCount = oldEvent.getTicketsCount();
        } else {
            try {
                ticketCount = Long.parseLong(ticketCountStr);
            } catch (NumberFormatException e) {
                System.out.println("Неверное число. Оставлено старое значение.");
                ticketCount = oldEvent.getTicketsCount();
            }
        }

        System.out.print("Введите описание: ");
        String eventDescription = readLine();
        if (eventDescription.isEmpty()) eventDescription = oldEvent.getDescription();


        EventType eventType;
        System.out.println("Введите тип мероприятия (CONCERT, E_SPORTS, FOOTBALL): ");
        String eventTypeInput = userScanner.nextLine().trim();
        if (eventTypeInput.isEmpty()) {
            eventType = oldEvent.getEventType();
        } else {
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
        }

        Event newEvent = new Event(name, minAge, ticketCount, eventDescription, eventType);
        ticket.updateData(name, coordinates, price, discount, type, newEvent);

        System.out.println("===== Билет " + ticket.getId() + " успешно обновлён. =====");
        return true;
    }

    /**
     * Читает строку, убирает пробелы по краям.
     * */
    private String readLine() {
        String line = userScanner.nextLine();
        return line == null ? "" : line.trim();
    }

    public UpdateId(CollectionManager collManager, Scanner userScanner) {
        super(name, description, hasOperand);
        this.collManager = collManager;
        this.userScanner = userScanner;
    }
}
