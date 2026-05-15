package edu.project.service.command;

public class MaxByName extends Command{
    private final String name = "history";
    private final String description = "history : вывести последние 5 команд (без их аргументов)";
    private final boolean hasOperand = false;

    public MaxByName(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
