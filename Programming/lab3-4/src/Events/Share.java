package Events;
import java.util.Objects;

public class Share {
    protected final String name;
    protected String owner;
    protected double cost;
    protected int value;  // количество акций

    public Share (String name, String owner, double cost, int value) {
        this.name = name;
        this.owner = owner;
        this.cost = cost;
        this.value = value;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

//    protected void makeLaugh() {
//        System.out.println(name + " ничего кроме смеха не вызывает");
//    }

    @Override
    public String toString() {
        return "Events.Share{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", cost=" + cost +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Share share = (Share) o;
        return Double.compare(cost, share.cost) == 0 && value == share.value && Objects.equals(name, share.name) && Objects.equals(owner, share.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, cost, value);
    }
}
