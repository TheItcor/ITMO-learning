package edu.project.service.command;

public class Exit extends Command{
    private static final String name = "exit";
    private static final String description = "exit : завершить программу (без сохранения в файл)";
    private static final boolean hasOperand = false;

    @Override
    boolean execute() {
        System.exit(1);
        return true;
    }

    public Exit() {
        super(name, description, hasOperand);
    }
}
