package utils.ex14.workers;

import utils.ex14.MailMessage;
import utils.ex14.MailService;
import utils.ex14.Package;
import utils.ex14.Sendable;
import utils.ex14.exceptions.IllegalPackageException;
import utils.ex14.exceptions.StolenPackageException;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class ClassContainer {

    public static class UntrustworthyMailWorker implements MailService {

        private final MailService[] mailServices;
        private final RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            this.realMailService = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for(MailService service : mailServices) {
                mail = service.processMail(mail);
            }

            realMailService.processMail(mail);
            return mail;
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }
    }

    public static class Spy implements MailService {
        private final Logger logger;
        public static final String AUSTIN_POWERS = "Austin Powers";

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                logMessage(mailMessage);
            }

            return mail;
        }

        public void logMessage(MailMessage mailMessage) {
            String message = mailMessage.getMessage();
            String to = mailMessage.getTo();
            String from = mailMessage.getFrom();

            if (from.equals(AUSTIN_POWERS)) {
                logger.warning(String.format("Detected target mail correspondence: from %s to %s \"%s\"",
                        from, to, message));
            } else {
                logger.info(String.format("Usual correspondence: from %s to %s", from, to));
            }
        }
    }

    public static class Thief implements MailService {

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

    public static class Inspector implements MailService {

        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";
        public static final String STONES = "stones";

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof Package) {
                Package mailPackage = (Package) mail;
                checkPackage(mailPackage);
            }

            return mail;
        }

        private void checkPackage(Package mailPackage) {
            String content = mailPackage.getContent();

            if (content.equals(WEAPONS) || content.equals(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException("Package with content " + content + " is illegal");
            }

            if (content.equals(STONES)) {
                throw new StolenPackageException("Package with content " + content + " is stolen");
            }
        }
    }
}
