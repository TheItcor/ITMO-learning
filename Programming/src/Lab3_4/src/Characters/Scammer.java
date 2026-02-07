package Characters;

import java.util.Objects;
import Error.*;

public class Scammer extends Person implements Scammers{
    protected boolean hasEscaped;

    public boolean getBoleanStateEscaped() {
        return this.hasEscaped;
    }

    public void setHasEscaped(boolean a) {
        this.hasEscaped = a;
    }

    {



    }

    @Override
    public void dream() {}

    public Scammer(String name, boolean hasEscaped) {
        super(name, 100);
        this.hasEscaped = hasEscaped;
    }

    public void run() {
        if (hasEscaped) {
            System.out.println(name + " сбегажал");
        } else {
            throw new runException(name + " не может вызвать метод run(), т.к. hasEscaped = false");
        }
    }

    public void getCaught() {
        System.out.println(name + " поймали");
    }

    public boolean isEscaped() {
        return hasEscaped;
    }

    @Override
    public String toString() {
        return "Characters.Scammer{" +
                "hasEscaped=" + hasEscaped +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Scammer scammer = (Scammer) o;
        return hasEscaped == scammer.hasEscaped;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hasEscaped);
    }
}
