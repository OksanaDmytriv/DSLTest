package core.wrappers.forCollection;

import core.conditions.collection.CollectionCondition;
import core.conditions.element.ElementCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forElement.LazyElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {

    LazyElement get(int index);

    LazyCollection filter(ElementCondition condition);

    LazyElement find(ElementCondition condition);

    LazyCollection should(CollectionCondition... conditions);

    LazyCollection shouldBe(CollectionCondition... conditions);

    LazyCollection shouldHave(CollectionCondition... conditions);
}
