import org.junit.Test;
import pages.Mails;
import pages.Menu;
import testconfigs.Gmail;
import testdata.AccountData;

import static core.Helpers.getUniqueText;


public class GmailTest extends Gmail {

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        pages.Gmail.visit();
        pages.Gmail.login(AccountData.email, AccountData.password);

        Mails.send(AccountData.email, subject);
        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.openSent();
        Mails.assertMail(0, subject);

        Menu.openInbox();
        Menu.search(subject);
        Mails.assertMails(subject);
    }
}

