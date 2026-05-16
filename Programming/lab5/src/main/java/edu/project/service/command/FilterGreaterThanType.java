package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;
import edu.project.service.collection.TicketType;

import java.util.Set;
import java.util.stream.Collectors;

public class FilterGreaterThanType extends Command{
    private final static String name = "filter_greater_than_type";
    private final static String description = "filter_greater_than_type type : вывести элементы, значение поля type которых больше заданного";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;

    @Override
    boolean execute(String operand) {
        // Определяем пороговый тип по вводу
        TicketType threshold = parseTicketType(operand.trim().toLowerCase());
        if (threshold == null) {
            System.out.println("[ERR] Неизвестный тип билета: " + operand);
            return false;
        }

        // Фильтруем билеты, у которых type != null и ordinal > порогового
        Set<Ticket> filtered = collManager.getTickets().stream()
                .filter(ticket -> ticket.getType() != null && ticket.getType().ordinal() > threshold.ordinal())
                .collect(Collectors.toSet());

        // Вывод результата
        if (filtered.isEmpty()) {
            System.out.println("Нет билетов с типом больше " + threshold);
        } else {
            System.out.println("Билеты с типом > " + threshold + ":");
            filtered.forEach(System.out::println);
        }
        return true;
    }

    private TicketType parseTicketType(String input) {
        switch (input) {
            case "с": case "стан": case "стандартный": case "usual":
                return TicketType.USUAL;
            case "б": case "бюд": case "бюджетный": case "budgetary":
                return TicketType.BUDGETARY;
            case "д": case "деш": case "дешёвый": case "cheap":
                return TicketType.CHEAP;
            default:
                return null;
        }
    }

    public FilterGreaterThanType(CollectionManager collManager) {
        super(name, description, hasOperand);
        this.collManager = collManager;
    }
}
