package edu.project.service.command;

public class CountLessThanEvent extends Command{
    private final String name = "count_less_than_event";
    private final String description = "count_less_than_event event : вывести количество элементов, значение поля event которых меньше заданного";
    private final boolean hasOperand = true;

    public CountLessThanEvent(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
