package org.akavity;

import io.appium.java_client.AppiumBy;
import org.akavity.utils.Utils;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ClickerTest extends BaseTest {

    @Test
    public void clickTest() {

        $(AppiumBy.xpath("//android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]" +
                "/android.widget.FrameLayout/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"))
                .shouldBe(visible)
                .click(tap());

        $(AppiumBy.xpath("(//android.widget.Button[@text=\"Играть в 1 клик \uD83D\uDC39\"])[3]"))
                .shouldBe(visible)
                .click();

        $(AppiumBy.xpath("//android.widget.Button[@text=\"Thank you, BingX\"]"))
                .shouldBe(visible)
                .click(tap());

        Utils.sleep(1000);
        int count = 40;
        while (count > 0) {
            Utils.clickCoordinates(630, 1020);
            Utils.clickCoordinates(830, 1020);
            count--;
        }
    }
}
