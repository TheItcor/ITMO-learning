package edu.project.service.command;

import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;

public class MaxByName extends Command{
    private final static String name = "max_by_name";
    private final static String description = "max_by_name: вывести любой объект из коллекции, значение поля name которого является максимальным";
    private final static boolean hasOperand = false;
    private final CollectionManager collManager;


    @Override
    boolean execute() {
        Ticket longest = null;
        int maxLen = -1;
        for (Ticket t : collManager.getTickets()) {
            int len = t.getName().length();
            if (len > maxLen) {
                maxLen = len;
                longest = t;
            }
        }
        if (longest != null) {
            System.out.println("Самое длинное имя у билета id=" + longest.getId() + ": " + longest.getName());
        } else {
            System.out.println("Коллекция пуста");
        }



        return true;
    }

    public MaxByName(CollectionManager collManager) {
        super(name, description, hasOperand);
        this.collManager = collManager;
    }
}
