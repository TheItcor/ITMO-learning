package edu.project.service;

import com.opencsv.exceptions.CsvValidationException;
import edu.project.service.collection.CollectionManager;
import edu.project.service.collection.Ticket;
import edu.project.service.collection.TicketCollectionBuilder;
import edu.project.service.command.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
V: 2821

*/

/**
 * Main class
 */
public class App {

    public static void main(String[] args) {
        boolean isRunning = true;

        //if (args.length == 0) {
        //    System.out.println("[ERR] Требуется имя файла");
        //    System.exit(1);
        //}

        String pathFile = "src/main/java/edu/project/storage/test.csv";

        // Создаём коллекцию Ticket:
        Set<Ticket> tickets = new HashSet<>(); // <--- Коллекция!
        TicketCollectionBuilder TktClnBuilder = new TicketCollectionBuilder();
        try {
            tickets = TktClnBuilder.build(pathFile);
        } catch (IOException | CsvValidationException e) {
            System.out.println("[ERR] Ошибка в .csv файле");
            System.exit(1);
        }

        // Управление коллекций (действия над коллекцией)
        CollectionManager CollManager = new CollectionManager(tickets);

        // Сохранение истории команд, которые были введены пользователем
        HistoryManager historyManager = new HistoryManager(5);

        // Пользовательский ввод
        Scanner userScanner = new Scanner(System.in);

        // Добавление команд в список
        CommandManager ComManager = new CommandManager();
        ComManager.addCommand("exit", new Exit());
        ComManager.addCommand("help", new Help(ComManager));
        ComManager.addCommand("clear", new Clear(CollManager));
        ComManager.addCommand("info", new Info(CollManager));
        ComManager.addCommand("show", new Show(CollManager));
        ComManager.addCommand("add", new Add(CollManager, userScanner));
        ComManager.addCommand("history", new History(historyManager));
        ComManager.addCommand("remove_by_id", new RemoveById(CollManager));



        // Интерпретатор команд (пользовательский ввод -> команда)
        Interpreter interpreter = new Interpreter(userScanner, ComManager, historyManager);

        while (isRunning) {
            interpreter.interpret();
        }

        System.out.println("--- End session ---");
    }
}
