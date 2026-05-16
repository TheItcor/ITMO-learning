package edu.project.service.command;

import edu.project.service.collection.*;

import java.util.Scanner;


/**
 * Класс для команды add - добавить новый экземпляр в коллекцию.
 */
public class Add extends Command {
    private static final String name = "add";
    private static final String description = "add {element} : добавить новый элемент в коллекцию";
    private static final boolean hasOperand = true;
    private final CollectionManager collectionManager;
    private final Scanner userScanner;



    /**
     * Метод для исполнения команды.
     * Вызывает конструктор и добавляет созданный билет в коллекцию.
     */
    @Override
    boolean execute() {

        TicketBuilder tktBuilder = new TicketBuilder(userScanner);
        Ticket newTicket = TicketMapper.fromRecord(tktBuilder.buildRecord());

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