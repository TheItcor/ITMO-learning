package edu.project.service.command;

public class UpdateId extends Command{
    private final static String name = "update";
    private final static String description = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    private final static boolean hasOperand = true;

    @Override
    boolean execute(String Operand) {


        return true;
    }

    public UpdateId(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
