package edu.project.service.command;


/**
 * Класс для команды history - вывести последние 5 команд.
 */
public class History extends Command{
    private final static String name = "history";
    private final static String description = "history : вывести последние 5 команд (без их аргументов)";
    private final static boolean hasOperand = false;
    private final HistoryManager historyManager;

    /**
     * Вывод последних нескольких команд.
     */
    @Override
    boolean execute() {

        if (historyManager.getHistory() != null) {
            for (String cmd : historyManager.getHistory()) {
                System.out.println(cmd);
            }
        } else {
            System.out.println("История команд пуста.");
        }
        return true;
    }

    public History(HistoryManager historyManager) {
        super(name, description, hasOperand);
        this.historyManager = historyManager;
    }
}
