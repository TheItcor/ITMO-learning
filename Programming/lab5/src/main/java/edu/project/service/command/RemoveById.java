package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;

import java.util.Set;

public class RemoveById extends Command{
    private final static String name = "remove_by_id";
    private final static String description = "remove_by_id id : удалить элемент из коллекции по его id";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;


    /**
     * Находит по ID нужного билета (Ticket) и удаляет его из коллекции.
     * @param ID - операнд, ID билета
     */
    @Override
    boolean execute(String ID) {


        Ticket ticket = collManager.findById(ID);
        try {
            collManager.deleteTicket(ticket);
        } catch (Exception e) {
            System.out.println("Не удалось удалить билет по ID");
            return false;
        }

        System.out.println("Билеты на " + ticket.getName() +" успешно удалёны.");
        return true;
    }

    public RemoveById(CollectionManager collManager) {
        super(name, description, hasOperand);
        this.collManager = collManager;
    }
}
