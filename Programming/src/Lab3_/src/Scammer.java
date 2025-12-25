public class Scammer extends Person implements Scammers{
    public Scammer(String name) {
        super(name, 0);
    }

    @Override
    public void run() {
        System.out.println(name + " сбегажал");
    }

    public boolean isEscaped() {
        return true;
    }
}
