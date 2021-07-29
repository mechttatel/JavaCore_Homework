package utils.ex14.workers;

import utils.ex14.MailService;
import utils.ex14.Package;
import utils.ex14.Sendable;
import utils.ex14.exceptions.IllegalPackageException;
import utils.ex14.exceptions.StolenPackageException;

public class Inspector implements MailService {

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
