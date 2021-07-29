package utils.ex14.workers;

import utils.ex14.MailService;
import utils.ex14.Sendable;

public class RealMailService implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
