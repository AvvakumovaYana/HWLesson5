import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5Test {
    @Test
    void githubTest (){
        open("https://github.com/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }

    @Test
    void dragDropTest (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }

    @Test
    void dragDrop2Test (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}
