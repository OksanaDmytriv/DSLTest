package core.wrappers.forElement;

import core.conditions.element.ElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement setValue(String text);

    LazyElement sendKeys(String text);

    LazyElement pressEnter();

    LazyElement pressEscape();

    LazyElement hover();

    LazyElement doubleClick();

    LazyElement should(ElementCondition... conditions);

    LazyElement shouldBe(ElementCondition... conditions);

    LazyElement shouldHave(ElementCondition conditions);

    boolean is(ElementCondition condition);

    boolean has(ElementCondition condition);

    LazyElement find(By innerLocator);

    LazyElement find(String cssSelector);

    LazyCollection findAll(By locator);

    LazyCollection findAll(String cssSelector);
}
