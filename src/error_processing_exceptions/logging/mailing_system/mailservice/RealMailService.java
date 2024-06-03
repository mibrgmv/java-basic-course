package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}