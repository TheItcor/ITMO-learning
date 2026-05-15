package edu.project.service.command;

public class FilterGreaterThanType extends Command{
    private final String name = "filter_greater_than_type";
    private final String description = "filter_greater_than_type type : вывести элементы, значение поля type которых больше заданного";
    private final boolean hasOperand = true;

    public FilterGreaterThanType(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
