package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;
import edu.project.service.collection.TicketBuilder;
import edu.project.service.collection.TicketMapper;

import java.util.Scanner;

/**
 * Команда для добавляющая элемент в коллекцию если значение меньше, чем у наименьшего элемента этой коллекции
 */
public class AddIfMin extends Command{
    private final static String name = "add_if_min";
    private final static String description = "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    private final static boolean hasOperand = true;
    private final CollectionManager collManager;
    private final Scanner userScanner;

    @Override
    boolean execute() {

        TicketBuilder tktBuilder = new TicketBuilder(userScanner);
        Ticket newTicket = TicketMapper.fromRecord(tktBuilder.buildRecord());

        if (newTicket.getPrice() < collManager.findTheMostCheapest()) {
            collManager.addTicket(newTicket);
            System.out.println("Билет успешно добавлен в коллекцию.");
        } else {
            System.out.println("Билет не добавлен в коллекцию, потому что цена элемента " + newTicket.getPrice() + " > наименьшего элемента в коллекции (" + collManager.findTheMostCheapest() + ")");
            return false;
        }

        return true;
    }

    public AddIfMin(CollectionManager collManager, Scanner userScanner) {
        super(name, description, hasOperand);
        this.collManager = collManager;
        this.userScanner = userScanner;
    }
}
