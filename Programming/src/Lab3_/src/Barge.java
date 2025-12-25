import java.util.ArrayList;
import java.util.List;

public enum Barge {
    BARGE1,
    BARGE2,
    BARGE3;

    // Затем объявляем поля (списки)
    private List<Shouter> employees = new ArrayList<>();
    private List<People> somePeople = new ArrayList<>();
    private List<Share> shares = new ArrayList<>();

    // Геттеры для доступа к спискам
    public List<Shouter> getEmployees() {
        return employees;
    }

    public List<People> getSomePeople() {
        return somePeople;
    }

    public List<Share> getShares() {
        return shares;
    }


    public void addEmployee(Shouter employee) {
        employees.add(employee);
    }

    public void addPerson(People person) {
        somePeople.add(person);
    }

    public void addShare(Share share) {
        shares.add(share);
    }
}