package edu.project.service.command;

public class UpdateId extends Command{
    private final String name = "update";
    private final String description = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    private final boolean hasOperand = false;

    public UpdateId(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
