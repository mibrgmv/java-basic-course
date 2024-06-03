package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

public interface MailService {
    Sendable processMail(Sendable mail);
}
