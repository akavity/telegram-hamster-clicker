package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ClickerPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class ClickerSteps {

    ClickerPage clickerPage = new ClickerPage();

    @Step
    public void clickHamsterChat() {
        log.info("Click hamster chat");
        clickerPage.getHamsterChat()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickPlayButton() {
        log.info("Click Play button");
        clickerPage.getPlayButton()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickStartButton() {
        log.info("Click start button");
        clickerPage.getStartButton()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickHamMoney() {
//        boolean flag = false;
        boolean timeWaiter = false;
        int countEnergy = 6;
        while (true) {    // flag
            int count = 266;
            while (count > 0) {
                Utils.clickCoordinates(630, 1020);      // координаты левого пальца
                Utils.clickCoordinates(930, 1020);      // координаты правого пальца
                count--;
            }
            if (timeWaiter == true) {
                Utils.sleepMinutes(61);  // 60 мин
                timeWaiter = false;
            } else if (countEnergy > 0 && timeWaiter == false) {
                clickerPage.getBoostButton().click(tap());
                clickerPage.getFullEnergy()
                        .shouldBe(visible)
                        .click(tap());
                clickerPage.getGoAheadEnergy()
                        .shouldBe(visible)
                        .click(tap());
                Utils.sleep();
                timeWaiter = true;
                countEnergy--;
            } else {
                Utils.sleepHours(12);  // наверное 12 часов
                countEnergy = 6;
            }
        }
    }
}
