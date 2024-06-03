package error_processing_exceptions.logging.mailing_system.mailservice;

import error_processing_exceptions.logging.mailing_system.sendable.MailPackage;
import error_processing_exceptions.logging.mailing_system.sendable.Package;
import error_processing_exceptions.logging.mailing_system.sendable.Sendable;

public class Thief implements MailService {

    private int minimumStealingValue;

    private int stolenValue;

    public Thief(int minimumStealingValue) {
        this.minimumStealingValue = minimumStealingValue;
        this.stolenValue = 0;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minimumStealingValue) {
            Package pac = ((MailPackage) mail).getContent();
            String content = pac.getContent();
            stolenValue += pac.getPrice();
            return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + content, 0));
        }
        return mail;
    }
}
