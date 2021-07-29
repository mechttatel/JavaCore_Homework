package utils.ex14.workers;

import utils.ex14.*;

import java.util.logging.Logger;

public class Spy implements MailService {
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
