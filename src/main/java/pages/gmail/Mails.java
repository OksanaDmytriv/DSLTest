package pages.gmail;

import org.openqa.selenium.By;
import core.wrappers.forCollection.LazyCollection;

import static core.conditions.collection.Core.*;
import static core.ConciseAPI.*;

public class Mails {

    public static LazyCollection emails = $$("[role='main'] .zA");

    public static void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public static void assertMails(String... subjects) {
        emails.shouldHave(texts(subjects));
    }

    public static void assertMail(int index, String subject) {
        emails.shouldHave(listNthElementHasText(index, subject));
    }
}
