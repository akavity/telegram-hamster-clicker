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
        Utils.sleep(5000);
    }

    @Step
    public void clickStartButton() {
        log.info("Click start button");
        clickerPage.getStartButton()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickHamMoney(int energyLimit, int fullEnergy, int multitap) {
        log.info("Start click hamster button");
        boolean timeWaiter = false;
        int countEnergy = fullEnergy;       // 6
        while (true) {    // flag
            int count = (int) Math.ceil((double) energyLimit / (multitap * 2));    // 266
            log.info("Amount double clicks: {}", count);
            while (count > 0) {
                Utils.clickCoordinates(630, 1020);      // координаты левого пальца
                Utils.clickCoordinates(930, 1020);      // координаты правого пальца
                count--;
            }
            if (timeWaiter == true) {
                log.info("////////  Sleep 60 minutes ////////");
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
                log.info("////////  Sleep 12 hours ////////");
                Utils.sleepHours(12);  // наверное 12 часов
                countEnergy = fullEnergy;   // 6
            }
        }
    }
}
