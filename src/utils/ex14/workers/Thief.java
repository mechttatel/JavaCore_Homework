package utils.ex14.workers;

import utils.ex14.MailService;
import utils.ex14.Package;
import utils.ex14.Sendable;

import java.lang.reflect.Field;

public class Thief implements MailService {

    private final int minPackagePrice;
    private int stolenValue;

    public Thief(int minPackageCost) {
        this.minPackagePrice = minPackageCost;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof Package) {
            Package mailPackage = (Package) mail;
            return (Sendable) checkAndSteal(mailPackage);
        }

        return mail;
    }

    public Package checkAndSteal(Package mailPackage) {
        int price = mailPackage.getPrice();
        String content = mailPackage.getContent();

        try {
            if (price >= minPackagePrice) {
                Class<?> packageClass = Package.class;
                Field contentField = packageClass.getDeclaredField("content");
                Field priceField = packageClass.getDeclaredField("price");
                contentField.setAccessible(true);
                priceField.setAccessible(true);

                contentField.set(mailPackage, "stones instead of " + content);
                priceField.set(mailPackage, 0);

                stolenValue += price;
                return mailPackage;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return mailPackage;
    }

    public int getStolenValue() {
        return stolenValue;
    }
}


