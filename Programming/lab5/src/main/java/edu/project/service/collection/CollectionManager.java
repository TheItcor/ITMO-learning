package edu.project.service.collection;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс для управления коллекцией Ticket
 * Сюда обращаются практически все команды наследующие абстрактный класс Command, например: add.
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

    public void addTicket(Ticket newTicket) {
        tickets.add(newTicket);
    }

    public Ticket findById(String ID) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == Integer.parseInt(ID)) {
                return ticket;
            }
        }

        return null;
    }

    public int findTheMostCheapest() {
        int min = Integer.MAX_VALUE;

        for (Ticket t : tickets) {
            if (t.getPrice() < min) {
                min = t.getPrice();
            }
        }
        return min;
    }

    public void deleteTicket(Ticket ticketToDelete){
        tickets.remove(ticketToDelete);
    }

    public void retainById(int id) {
        tickets.removeIf(ticket -> ticket.getId() != id);
    }

}
