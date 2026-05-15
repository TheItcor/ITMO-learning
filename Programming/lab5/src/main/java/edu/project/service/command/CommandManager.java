package edu.project.service.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Добавление новой команды в словарь команд по ключу строке. Использует HashMap.
     * @param commandName - название команды по которой будет поиск
     * @param command - непосредственно команда
     */
    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }



}
