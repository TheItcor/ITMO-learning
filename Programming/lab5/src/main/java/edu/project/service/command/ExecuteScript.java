package edu.project.service.command;

public class ExecuteScript extends Command{
    private final String name = "execute_script";
    private final String description = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    private final boolean hasOperand = true;

    public ExecuteScript(String name, String description, boolean hasOperand) {
        super(name, description, hasOperand);
    }
}
