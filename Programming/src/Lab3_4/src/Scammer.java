public class Scammer extends Person implements Scammers{
    protected boolean hasEscaped;

    public Scammer(String name, boolean hasEscaped) {
        super(name, 100);
        this.hasEscaped = hasEscaped;
    }

    public void run() {
        if (hasEscaped) {
            System.out.println(name + " сбегажал");
        } else {
            throw new RuntimeException(name + " не может вызвать метод run(), т.к. hasEscaped = false");
        }
    }

    public boolean isEscaped() {
        return hasEscaped;
    }
}
