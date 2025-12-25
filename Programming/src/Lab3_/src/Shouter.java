public class Shouter extends Person implements Employee {
    public Shouter(String name, int money) {
        super(name, money);
    }

    @Override
    public void first_work() {}

    public void first_work(Share share) {
        System.out.println("Горлодерик предлагает " + share.getName() + " по " + share.getCost() + " фертинг за штуку.");
    }


    public void another_work() {
        System.out.println("Делаем другую работу...");
    }
}
