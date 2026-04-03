package edu.project5.temp5.service.collection;

import edu.project5.app.service.collection.EventType;

public class Event {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int minAge;
    private Long ticketsCount; //Поле не может быть null, Значение поля должно быть больше 0
    private String description; //Длина строки не должна быть больше 1774, Поле не может быть null
    private EventType eventType; //Поле не может быть null
}
