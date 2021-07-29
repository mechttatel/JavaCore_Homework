package utils.ex14.workers;

import utils.ex14.MailService;
import utils.ex14.Sendable;

public class UntrustworthyMailWorker implements MailService {

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
