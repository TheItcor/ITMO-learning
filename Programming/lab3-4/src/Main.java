import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.*;
import Events.News;
import Events.Share;
import Error.runException;

// 34242

public class Main {
    public static void main(String[] args) {
        Investor Skuperfield = new Investor("Скуперфильд", 20);
        Scammer Migi = new Scammer("Миги", true);
        Scammer Zhulio = new Scammer("Жулио", true);
        List<Scammer> scammerList = new ArrayList<>();
        scammerList.add(Migi);
        scammerList.add(Zhulio);

        Shouter newGorloderik = new Shouter("Горлодерик", 0);

        Random random = new Random();
        int shareCost = random.nextInt(1, 3);

        Share giganticShare = new Share("Гигантская Акция", "Скуперфильд", shareCost, 100);

        // Начало сценария:

        Skuperfield.order(); // Скуперфилд приказывает продавать акции
        newGorloderik.first_work(giganticShare);

        PeopleReaction reaction = random.nextBoolean() ? PeopleReaction.LAUGH : PeopleReaction.IGNORE;
        reaction.getReaction(giganticShare);
        //giganticShare.makeLaugh();

        for (int i = 1; i < random.nextInt(1, 8); i++) {
            Skuperfield.reducePrice(giganticShare, 0.1d);
        }

        reaction = random.nextBoolean() ? PeopleReaction.ANGER : PeopleReaction.IGNORE;
        reaction.getReaction(giganticShare);
        Skuperfield.dream();

        Skuperfield.reducePrice(giganticShare, 0.2d);
        Skuperfield.leavePrice(giganticShare);

        Skuperfield.waitDay();

        // Конец, новости
        News newsToday = new News(giganticShare,true);
        newsToday.publishNews();
        reaction = PeopleReaction.ANGER;
        reaction.getReaction(giganticShare);

        for (Scammer oneScammer : scammerList) {
            try {
                if (random.nextBoolean()) {
                    oneScammer.getCaught();
                } else {
                    oneScammer.run();
                }
            } catch (runException runException) {
                System.out.println("[Ошибка] " + runException.getMessage());
            }
        }
        newsToday.publishPhoto();
    }
}
