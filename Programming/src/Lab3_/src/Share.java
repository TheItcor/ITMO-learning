public class Share {
    String name;
    String owner;
    float cost;
    int value;  // количество акций

    public Share (String owner, float cost) {
        this.owner = owner;
        this.cost = cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getCost() {
        return cost;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
