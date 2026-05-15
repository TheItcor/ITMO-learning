package edu.project.service.collection;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/** Класс для управления коллекцией Ticket
 *  Сюда обращаются практически все команды наследующие абстрактный класс Command, например: add.
 */
public class CollectionManager {
    private Set<Ticket> tickets = new HashSet<>();
    private final ZonedDateTime initDate;

    public CollectionManager(Set<Ticket> tickets) {
        this.tickets = tickets;
        this.initDate = ZonedDateTime.now();
    }

    public void deleteAll() {
        // Просто возвращаем новую пустую коллекции
        this.tickets = new HashSet<>();
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public ZonedDateTime getInitDate() {
        return initDate;
    }

    public int getSize() {
        return tickets.size();
    }


}
