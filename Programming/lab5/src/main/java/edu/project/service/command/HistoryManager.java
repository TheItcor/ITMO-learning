package edu.project.service.command;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Класс для хранения истории команд.
 * Если массив заполнен на maxSize, а на вход идёт новая команда - самая старая команда удаляется.
 */
public class HistoryManager {
    private final Deque<String> history = new ArrayDeque<>();
    private final int maxSize;


    public HistoryManager(int maxSize) {
        this.maxSize = maxSize;
    }


    /**
     * добавляем команду в историю.
     * @param command - добавление команды в историю
     */
    public void add(String command) {
        if (history.size() == maxSize) {
            history.pollFirst(); // удалить самую старую
        }
        history.offerLast(command); // добавить в конец
    }

    /**
     * Получить историю последних команд.
     * @return history
     */
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

}
