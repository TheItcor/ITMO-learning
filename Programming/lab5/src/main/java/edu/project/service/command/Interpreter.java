package edu.project.service.command;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Класс-интерпретатор для запуска команд.
 */
public class Interpreter {
    private final Scanner userScanner;
    private final CommandManager comManager;
    private final HistoryManager historyManager;
    private boolean interactiveMode = true;
    private String filePath;

    /**
     * Интерпретация пользовательского ввода. Работает в зависимости от поля interactiveMode.
     * Если InteractiveMode = true, то идёт выполнение в интерактивном режиме.
     * Если InteractiveMode = false, то идёт выполнение команд из файла.
     */
    public void interpret() {
        String input = "";

        // Режим чтения из файла / режим интерпретации из ввода пользователя
        if (interactiveMode) {
            input = userScanner.nextLine();
            executeCommand(input);
        } else {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
                 InputStreamReader isr = new InputStreamReader(bis, StandardCharsets.UTF_8);
                 BufferedReader br = new BufferedReader(isr)) {

                String line;
                while ((line = br.readLine()) != null) {

                    executeCommand(line);
                }

            } catch (IOException e) {
                System.err.println("[ERR] Ошибка чтения: " + e.getMessage());
            }

            switchMode(); // возвращаемся в интерактивный режим
        }
    }

    public void executeCommand(String input) {
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


    /**
     * Сменить режим интерпретатора.
     * Интерактивный режим -> Режим чтения
     * Режим чтения -> Интерактивный режим
     */
    public void switchMode() {
        interactiveMode = !interactiveMode;
    }

    /**
     * Сменить путь к папке для режима интерпретирования из файла.
     * @param newFilePath - новый путь к файлу для интерпретатора
     */
    public void changeFilePath(String newFilePath) {
        filePath = newFilePath;
    }
}
