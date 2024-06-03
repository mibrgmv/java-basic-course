package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.sendable.MailMessage;
import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {

    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage && (mail.getFrom().equals("Austin Powers") || mail.getTo().equals("Austin Powers"))) {
            logger.log(Level.WARNING, String.format("Detected target error_processing_exceptions.logging.mail correspondence: from %s to %s \"%s\"", mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()));
        } else if (mail instanceof MailMessage) {
            logger.log(Level.INFO, String.format("Usual correspondence: from %s to %s", mail.getFrom(), mail.getTo()));
        }
        return mail;
    }
}
