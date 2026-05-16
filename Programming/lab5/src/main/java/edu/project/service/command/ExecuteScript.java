package edu.project.service.command;

import java.io.*;

/**
 * Класс для команды execute_script {filePath} - считать и исполнить последовательность команд из указанного файла.
 */
public class ExecuteScript extends Command{
    private final static String name = "execute_script";
    private final static String description = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    private final static boolean hasOperand = true;
    private final Interpreter interpreter;


    /**
     * Метод для исполнения.
     * Меняет режим работы интерпретатора с интерактивного на чтение и передаёт в интерпретатор путь к файлу.
     * @param filePath - путь к файлу.
     */
    @Override
    boolean execute(String filePath) {

        interpreter.switchMode(); // переключаемся в режим интерпретации из файла

        interpreter.changeFilePath(filePath); // Теперь интерпретатор будет считывать команды отсюда


        return true;
    }

    public ExecuteScript(Interpreter interpreter) {
        super(name, description, hasOperand);
        this.interpreter = interpreter;
    }
}
