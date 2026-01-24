public class Shouter extends Person implements Employee {
    protected Shouter(String name, int money) {
        super(name, money);
    }

    @Override
    public void dream() {}

    public void first_work(Share share) {
        System.out.println("Горлодерик предлагает " + share.getName() + " по " + share.getCost() + " фертинг за штуку.");
    }

    public void another_work() {
        System.out.println("Делаем другую работу...");
    }
}
