package edu.project.service.command;

public class AddIfMin extends Command{
    private final String name = "add_if_min";
    private final String description = "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента \n" +
            "    этой коллекции";
    private final boolean hasOperand = true;

    public AddIfMin(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
