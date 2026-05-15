package edu.project.service.command;

public class Save extends Command {
    private final String name = "save";
    private final String description = "save : сохранить коллекцию в файл";
    private final boolean hasOperand = false;

    public Save(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
