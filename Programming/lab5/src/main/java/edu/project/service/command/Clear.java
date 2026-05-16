package edu.project.service.command;

import edu.project.service.collection.CollectionManager;


/**
 * Класс для команды clear - очистка коллекции.
 */
public class Clear extends Command{
    private static final String name = "clear";
    private static final String description = "clear : очистить коллекцию";
    private static final boolean hasOperand = false;
    private CollectionManager CollectionManager;


    /**
     * Метод для исполнения команды.
     * Вызывает метод из менеджера коллекций для удаления всех элементов.
     */
    @Override
    boolean execute() {
        CollectionManager.deleteAll();

        return true;
    }

    public Clear(CollectionManager CollectionManager) {
        super(name, description, hasOperand);
        this.CollectionManager = CollectionManager;
    }
}
