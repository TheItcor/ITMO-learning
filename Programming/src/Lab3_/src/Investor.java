public class Investor extends Person implements ShareOwner, Employer {
    public Investor(String name, int money) {
        super(name, money);
    }

    public void order() {
        System.out.println(name + " отдал распоряжение продавать акции.");
    }

    public void order(Share share) {
        System.out.println(name + " отдал распоряжение продавать акции по " + share.getCost() + " фертингов");
    }

    public void dream() {
        System.out.println(name + " мечтает уже лишь о том, чтоб хотя бы вернуть свои деньги.");
    }

    public void leavePrice(Share share) {
        System.out.println(share.getOwner() + " решил не снижать больше цену.");
    }

    public void reducePrice(Share share, double price) {
        /*Умеьшение цены на н фертингов*/
        double newPrice =  share.getCost() - price;
        share.setCost(newPrice);
        System.out.println(share.getOwner() + " уменьшает цену до " + String.format("%.1f", newPrice) + " фертингов за штуку"); // используем string.format из-за проблемы арифметики с плавающей точкой
    }

    public void waitDay() {
        System.out.println(name + " ждёт следующего дня...");
    }
}
