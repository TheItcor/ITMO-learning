package edu.project.service.command;

/**
 * Абстрактный класс для создания комманд.
 */
public abstract class Command {
    private final String name;
    private final String description;
    private final boolean hasOperand;

    boolean execute() {
        return false;
    };

    public String getDescription() {
        return description;
    }

    public boolean isHasOperand() {
        return hasOperand;
    }

    public String getName() {
        return name;
    }

    public Command(String name, String description, boolean hasOperand) {
        this.name = name;
        this.description = description;
        this.hasOperand = hasOperand;
    }
}
