import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Investor Skuperfield = new Investor("Скуперфильд", 20);
        Scammer Migi = new Scammer("Миги", true);
        Scammer Zhulio = new Scammer("Жулио", true);
        List<Scammer> scammerList = new ArrayList<>();
        scammerList.add(Migi);
        scammerList.add(Zhulio);

        Shouter newGorloderik = new Shouter("Горлодерик", 0);

        Share giganticShare = new Share("Гигантская Акция", "Скуперфильд", 1, 100);

        // Начало сценария:

        Skuperfield.order(); // Скуперфилд приказывает продавать акции
        newGorloderik.first_work(giganticShare);

        PeopleReaction reaction = PeopleReaction.LAUGH;
        giganticShare.makeLaugh();

        Skuperfield.reducePrice(giganticShare, 0.1d);
        Skuperfield.reducePrice(giganticShare, 0.1d);
        Skuperfield.reducePrice(giganticShare, 0.1d);

        reaction = PeopleReaction.IGNORE;
        Skuperfield.dream();

        Skuperfield.reducePrice(giganticShare, 0.2d);
        Skuperfield.leavePrice(giganticShare);

        Skuperfield.waitDay();

        // Конец, новости
        reaction = PeopleReaction.ANGER;
        News newsToday = new News(giganticShare,true);
        newsToday.publishNews();

        for (Scammer oneScammer : scammerList) {
            try {
                oneScammer.run();
            } catch (Exception e) {
                System.out.println("[Ошибка] " + e.getMessage());
            }
        }
        newsToday.publishPhoto();
    }
}
