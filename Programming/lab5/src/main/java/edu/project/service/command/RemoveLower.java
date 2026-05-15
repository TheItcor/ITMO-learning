package edu.project.service.command;

public class RemoveLower extends Command{
    private final String name = "remove_lower";
    private final String description = "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    private final boolean hasOperand = true;


    public RemoveLower(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
