package edu.project.service.command;

import edu.project.service.collection.CollectionManager;

public class Add extends Command {
    private static final String name = "add";
    private static final String description = "add {element} : добавить новый элемент в коллекцию";
    private static final boolean hasOperand = true;
    private CollectionManager collectionManager;


    public Add(CollectionManager collectionManager) {
        super(name, description, hasOperand);
        this.collectionManager = collectionManager;
    }
}
