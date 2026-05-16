package edu.project.service.command;

import edu.project.service.collection.Ticket;
import edu.project.service.fileio.CsvWriter;

import java.io.IOException;
import java.util.Set;

public class Save extends Command {
    private final static String name = "save";
    private final static String description = "save : сохранить коллекцию в файл";
    private final static boolean hasOperand = false;
    private final CsvWriter writer;
    private final Set<Ticket> tickets;
    private final String filePath;

    @Override
    boolean execute() {
        try {
            writer.writeTickets(tickets, filePath);
        } catch (Exception e) {
            System.out.println("Ошибка при записи в файл.");
            return false;
        }

        System.out.println("Успешная запись в файл.");
        return true;
    }

    public Save(CsvWriter writer, Set<Ticket> tickets, String filePath) {
        super(name, description, hasOperand);
        this.writer = writer;
        this.filePath = filePath;
        this.tickets = tickets;
    }
}
