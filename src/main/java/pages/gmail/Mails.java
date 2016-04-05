package pages.gmail;

import core.wrappers.forCollection.LazyCollectionByInnerLocator;
import org.openqa.selenium.By;

import static core.ConciseAPI.$;
import static core.ConciseAPI.byText;
import static core.conditions.collection.CustomCollectionConditions.listNthElementHasText;
import static core.conditions.collection.CustomCollectionConditions.texts;

public class Mails {

    public static LazyCollectionByInnerLocator emails = $("[role='main']").findAll(".zA");

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
