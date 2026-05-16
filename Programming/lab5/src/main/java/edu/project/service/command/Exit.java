package edu.project.service.command;


/**
 * Класс для команды exit - выход без сохранения.
 */
public class Exit extends Command{
    private static final String name = "exit";
    private static final String description = "exit : завершить программу (без сохранения в файл)";
    private static final boolean hasOperand = false;


    /**
     * Метод для исполнения команды
     */
    @Override
    boolean execute() {
        System.exit(1);
        return true;
    }

    public Exit() {
        super(name, description, hasOperand);
    }
}
