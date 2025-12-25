public class Main {
    public static void main(String[] args) {
        Investor Skuperfield = new Investor("Скуперфильд", 20);
        Scammer Migi = new Scammer("Миги");
        Scammer Zhulio = new Scammer("Жулио");
        Shouter newGorloderik = new Shouter("Горлодерик", 0);

        Share giganticShare = new Share("Гигантская Акция", "Скуперфильд", 1, 100);

        // Начало сценария:

        Skuperfield.order(); // Скуперфилд приказывает продавать акции
        newGorloderik.first_work(giganticShare);

        giganticShare.makeLaugh();

        Skuperfield.reducePrice(giganticShare, 0.1d);
        Skuperfield.reducePrice(giganticShare, 0.1d);
        Skuperfield.reducePrice(giganticShare, 0.1d);

        Skuperfield.dream();

        Skuperfield.reducePrice(giganticShare, 0.2d);
        Skuperfield.leavePrice(giganticShare);

        Skuperfield.waitDay();

        // конец
        News.publishNews();
        if (Migi.isEscaped() && Zhulio.isEscaped()) {
            Migi.run();
            Zhulio.run();
        }
        News.publishPhoto();
        People.revoltInStroke(giganticShare);
        People.demandMoney(giganticShare);


    }
}
