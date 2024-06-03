package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.exceptions.IllegalPackageException;
import error_processing_exceptions.logging.mailing_system.exceptions.StolenPackageException;
import error_processing_exceptions.logging.mailing_system.sendable.MailPackage;
import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

import java.util.Objects;

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && Objects.equals(((MailPackage) mail).getContent().getContent(), "weapons")) {
            throw new IllegalPackageException();
        } else if (mail instanceof MailPackage && Objects.equals(((MailPackage) mail).getContent().getContent(), "banned substance")) {
            throw new IllegalPackageException();
        } else if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getContent().contains("stones")) {
            throw new StolenPackageException();
        }
        return mail;
    }
}
