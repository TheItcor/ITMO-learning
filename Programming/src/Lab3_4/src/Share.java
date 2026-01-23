public class Share {
    protected final String name;
    protected String owner;
    protected double cost;
    protected int value;  // количество акций

    protected Share (String name, String owner, double cost, int value) {
        this.name = name;
        this.owner = owner;
        this.cost = cost;
        this.value = value;
    }

    protected void setCost(double cost) {
        this.cost = cost;
    }

    protected double getCost() {
        return cost;
    }

    protected String getOwner() {
        return owner;
    }

    protected String getName() {
        return name;
    }

    protected void makeLaugh() {
        System.out.println(name + " ничего кроме смеха не вызывает");
    }
}
