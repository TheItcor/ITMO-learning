package edu.project.service.command;

import java.util.Map;

/**
 * Класс для команды help - вывод всех команд.
 */
public class Help extends Command{
    private static final String name = "help";
    private static final String description = "help : вывести справку по доступным командам";
    private static final boolean hasOperand = false;
    private CommandManager commandManager = null;

    /**
     * Метод для исполнения команды
     */
    @Override
    boolean execute() {
        Map<String, Command> allCommands = commandManager.getCommands();


        System.out.println("      ----- Список команд ----- ");
        for (Command cmd : allCommands.values()) {
            System.out.println(cmd.getDescription());
        }
        return true;
    }

    public Help(CommandManager commandManager) {
        super(name, description, hasOperand);
        this.commandManager = commandManager;
    }

}
