package edu.project.service.command;

import java.util.Scanner;

/**
 * Интерпретатор для команд.
 */
public class Interpreter {
    /**
     * Интерпретация пользовательского ввода
     * @param userScanner - Scanner пользователя
     * @param ComManager - Менеджер команд
     *
     * p.s. ComManager возможно стоит изменить на map<String, Command> для большей безопасности...
     */
    public void interpret(Scanner userScanner, CommandManager ComManager) {
        String input = userScanner.nextLine();

        // Разбиваем строку введенную пользователем на "Команда Аргумент1 Аргумент2"
        String[] userInputSplit = input.trim().split("\\s+");

        // Получаем команду из менеджера команд по ключу userInputSplit[0]
        Command cmd = ComManager.getCommands().get(userInputSplit[0]);

        // Выполнение
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("[ERR] Неизвестная команда: " + userInputSplit[0]);
        }
    }

}
