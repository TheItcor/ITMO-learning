package Characters;
import Events.Share;

public class People {

    public static void revoltInStroke(Share share) {
        System.out.println("Разъяренная толпа ворвалась в контору по продаже " + share.getName() + ".");
    }

    public static void demandMoney(Share share)  {
        System.out.println("Разъяренная толпа потребовала свои деньги по акциям " + share.getName() + " обратно.");
    }

}


