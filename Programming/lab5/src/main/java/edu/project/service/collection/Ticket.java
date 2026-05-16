package edu.project.service.collection;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Ticket {
    private static int generalID = 1;


    private Integer id;                           //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name = "DefaultName";          //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates;              //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price;                        //Поле не может быть null, Значение поля должно быть больше 0
    private Double discount;                      //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private TicketType type;                      //Поле может быть null
    private Event event;                          //Поле не может быть null

    public Ticket(String name, Coordinates coordinates, Integer price, Double discount, TicketType type, Event event) {
        if (discount > 100) throw new IllegalArgumentException("[ERR]: discount > 100");
        if (discount <= 0) throw new IllegalArgumentException("[ERR]: discount <= 0");
        if (price <= 0) throw new IllegalArgumentException("[ERR]: price <= 0");


        this.id = generalID++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.discount = discount;
        this.type = type;
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id " + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", discount=" + discount +
                ", type=" + type +
                ", event=" + event +
                '}';
    }

    public static int getGeneralID() {
        return generalID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public TicketType getType() {
        return type;
    }

    public Event getEvent() {
        return event;
    }

    public void updateData(String name, Coordinates coordinates, Integer price,
                           Double discount, TicketType type, Event event) {
        this.name = name;
        this.coordinates = coordinates;
        this.price = price;
        this.discount = discount;
        this.type = type;
        this.event = event;
    }
}
