package edu.project.service.command;

import edu.project.service.collection.CollectionManager;

/**
 * Класс для команды count_less_than_event {event} - вывести количество элементов, в которых количество билетов меньше заданного.
 */
public class CountLessThanEvent extends Command{
    private final static String name = "count_less_than_event";
    private final static String description = "count_less_than_event event : вывести количество элементов, значение поля event которых меньше заданного";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;

    /**
     * Метод для исполнения команды.
     * Сравнивает все элементы и подсчитывает количество элементов, где значение билетов < чем в операнде.
     */
    @Override
    boolean execute(String operand) {
        long threshold;
        try {
            threshold = Long.parseLong(operand.trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERR]: введите целое число (ticketsCount)");
            return false;
        }

        long count = collManager.getTickets().stream()
                .filter(ticket -> ticket.getEvent().getTicketsCount() < threshold)
                .count();

        System.out.println("Количество билетов < " + threshold + ": " + count);
        return true;
    }

    public CountLessThanEvent(CollectionManager collManager1) {
        super(name, description, hasOperand);
        this.collManager = collManager1;
    }
}
