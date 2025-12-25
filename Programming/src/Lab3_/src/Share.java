public class Share {
    String name, owner;
    double cost;
    int value;  // количество акций

    public Share (String name, String owner, double cost, int value) {
        this.name = name;
        this.owner = owner;
        this.cost = cost;
        this.value = value;
    }

    public void setCost(double cost) {
        this.cost = (double) cost;
    }

    public double getCost() {
        return cost;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void makeLaugh() {
        System.out.println(name + " ничего кроме смеха не вызывает");
    }
}
