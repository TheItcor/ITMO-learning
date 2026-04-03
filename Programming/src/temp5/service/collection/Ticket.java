package edu.project5.temp5.service.collection;

import edu.project5.app.service.collection.Coordinates;
import edu.project5.app.service.collection.Event;
import edu.project5.app.service.collection.TicketType;

public class Ticket {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price; //Поле не может быть null, Значение поля должно быть больше 0
    private Double discount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private TicketType type; //Поле может быть null
    private Event event; //Поле не может быть null
}