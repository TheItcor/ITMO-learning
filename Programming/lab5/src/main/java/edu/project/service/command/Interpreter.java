package edu.project.service.command;

import java.util.Scanner;

/**
 * Интерпретатор для команд.
 */
public class Interpreter {
    private final Scanner userScanner;
    private final CommandManager comManager;
    private final HistoryManager historyManager;

    /**
     * Интерпретация пользовательского ввода
     * p.s. ComManager возможно стоит изменить на map<String, Command> для большей безопасности...
     */
    public void interpret() {
        String input = userScanner.nextLine();

        // Разбиваем строку, введенную пользователем на "Команда Аргумент1 Аргумент2"
        String[] userInputSplit = input.trim().toLowerCase().split("\\s+");

        // Получаем команду из менеджера команд по ключу userInputSplit[0]
        Command cmd = comManager.getCommands().get(userInputSplit[0]);



        // Добавляем команду в историю команд, если команда "history", то не добавляем её ибо зачем
        if (!userInputSplit[0].equals("history")) { historyManager.add(userInputSplit[0]); }

        // Выполнение
        if (cmd != null) {
            try {
                // Если есть аргумент, передаём его, иначе вызываем без аргументов
                if (userInputSplit.length > 1) {
                    cmd.execute(userInputSplit[1]);
                } else {
                    cmd.execute();
                }
            } catch (Exception e) {
                System.err.println("[ERR] Ошибка выполнения команды: " + e.getMessage());
            }
        } else if (!userInputSplit[0].isEmpty()) {
            System.out.println("[ERR] Неизвестная команда: " + userInputSplit[0]);
        }
    }

    public Interpreter(Scanner userScanner, CommandManager comManager, HistoryManager historyManager) {
        this.userScanner = userScanner;
        this.comManager = comManager;
        this.historyManager = historyManager;
    }
}
