package edu.project.service.command;

import java.io.IOException;

/**
 * Абстрактный класс для создания комманд.
 */
public abstract class Command {
    private final String name;
    private final String description;
    private final boolean hasOperand;

    /**
     * Выполнение команды без операнда
     * @return - статус выполнения команды
     */
    boolean execute(){
        return false;
    }

    /**
     * Выполнение команды с операндом
     * @param operand - операнд
     * @return - статус выполнения команды
     */
    boolean execute(String operand) {
        return false;
    }

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
