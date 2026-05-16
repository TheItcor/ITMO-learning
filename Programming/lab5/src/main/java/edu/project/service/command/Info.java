package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;

import java.util.Set;


/**
 * Класс для команды info - вывод информацию о коллекции.
 */
public class Info extends Command {
    private static final String name = "info";
    private static final String description = "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    private static final boolean hasOperand = false;
    private CollectionManager collectionManager;


    /**
     * Метод для исполнения команды
     */
    @Override
    boolean execute() {

        Set<Ticket> tickets = collectionManager.getTickets();

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }

        //тип, дата инициализации, количество элементов и т.д.
        System.out.println("Дата инициализации: " + collectionManager.getInitDate());
        System.out.println("Количество элементов: " + collectionManager.getSize());

        return true;
    }

    public Info(CollectionManager collectionManager) {
        super(name, description, hasOperand);
        this.collectionManager = collectionManager;
    }
}
