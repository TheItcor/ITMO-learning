package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;

/**
 * Класс для команды remove_lower {element} - удаление из коллекции экземпляров, которые по цене меньше чем заданный.
 */
public class RemoveLower extends Command{
    private final static String name = "remove_lower";
    private final static String description = "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;

    /**
     * Метод для исполнения команды
     */
    @Override
    boolean execute(String ID) {
        Ticket oneTicket = collManager.findById(ID);
        if (oneTicket == null) {
            System.out.println("Билет с ID " + ID + " не найден.");
            return false;
        }

        // Удаляем все билеты, у которых цена меньше
        collManager.getTickets().removeIf(ticket -> ticket.getPrice() < oneTicket.getPrice());
        System.out.println("Удалены все билеты с ценой меньше " + oneTicket.getPrice());
        return true;
    }

    public RemoveLower(CollectionManager collManager) {
        super(name, description, hasOperand);
        this.collManager = collManager;
    }
}
