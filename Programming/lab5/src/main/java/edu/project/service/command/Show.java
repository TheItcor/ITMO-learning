package edu.project.service.command;
import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;

import java.util.Set;

public class Show extends Command {
    private static final String name = "show";
    private static final String description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    private static final boolean hasOperand = false;
    private CollectionManager collectionManager;

    @Override
    boolean execute() {

        Set<Ticket> tickets = collectionManager.getTickets();

        for (Ticket t : tickets) {
            System.out.println("ID Билета: " + t.getId());
            System.out.println("  Название: " + t.getName());
            System.out.println("  Координаты: " + t.getCoordinates());
            System.out.println("  Дата создания: " + t.getCreationDate());
            System.out.println("  Цена: " + t.getPrice() + " Руб.");
            System.out.println("  Скидка: " + t.getDiscount() + "%");
            System.out.println("  Тип: " + (t.getType() != null ? t.getType() : "null (optional)"));
            System.out.println("  Мероприятие: " + t.getEvent());
            System.out.println("----------------------------------------");
        }


        return true;
    }

    public Show(CollectionManager collectionManager) {
        super(name, description, hasOperand);
        this.collectionManager = collectionManager;
    }
}
