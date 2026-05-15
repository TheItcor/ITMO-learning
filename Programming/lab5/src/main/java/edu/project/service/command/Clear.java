package edu.project.service.command;

import edu.project.service.collection.CollectionManager;

public class Clear extends Command{
    private static final String name = "clear";
    private static final String description = "clear : очистить коллекцию";
    private static final boolean hasOperand = false;
    private CollectionManager CollectionManager;

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
