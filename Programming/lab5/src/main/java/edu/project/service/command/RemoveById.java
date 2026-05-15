package edu.project.service.command;

public class RemoveById extends Command{
    private final String name = "remove_by_id";
    private final String description = "remove_by_id id : удалить элемент из коллекции по его id";
    private final boolean hasOperand = true;

    public RemoveById(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
