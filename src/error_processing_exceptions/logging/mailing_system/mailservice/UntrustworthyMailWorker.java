package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

public class UntrustworthyMailWorker implements MailService {

    private RealMailService realMailService = new RealMailService();

    private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        int i = 0;
        while (i < mailServices.length) {
            mail = mailServices[i++].processMail(mail);
        }
        return realMailService.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}