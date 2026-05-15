package edu.project.service.collection;

public class Event {
    private static Long generalID = 0L;

    private Long id;             //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name;         //Поле не может быть null, Строка не может быть пустой
    private int minAge;
    private Long ticketsCount;   //Поле не может быть null, Значение поля должно быть больше 0
    private String description;  //Длина строки не должна быть больше 1774, Поле не может быть null
    private EventType eventType; //Поле не может быть null

    public Event(String name, int minAge, Long ticketsCount, String description, EventType eventType) {
        if (description.length() > 1774) throw new IllegalArgumentException("[ERR]: description length > 1774");

        this.id = generalID++;
        this.name = name;
        this.minAge = minAge;
        this.ticketsCount = ticketsCount;
        this.description = description;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public Long getTicketsCount() {
        return ticketsCount;
    }

    public String getDescription() {
        return description;
    }

    public EventType getEventType() {
        return eventType;
    }
}
