package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ClickerPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class ClickerSteps {
    final int ENERGY_IN_SEC = 3;
    final int SECONDS_IN_MIN = 60;
    final int MINUTES_IN_HOUR = 60;
    final int MINUTES_IN_DAY = 1440;
    final int MS_IN_S = 1000;
    final int Y_OFFSET = 1020;
    final int LEFT_X_OFFSET = 630;
    final int MIDDLE_X_OFFSET = 780;
    final int RIGHT_X_OFFSET = 930;
    final int DOUBLE_CLICK = 2;

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
    public void clickHamMoney(int energyLimit, int fullEnergy, int multitap) {
        boolean timeWaiter = false;
        int countEnergy = fullEnergy;
        while (true) {
            int count = energyLimit / (multitap * DOUBLE_CLICK) + ((energyLimit % (multitap * DOUBLE_CLICK) == 0) ? 0 : 1);
            log.info("Double click is started");
            log.info("Amount double clicks: {}", count);
            while (count > 0) {
                Utils.clickCoordinates(LEFT_X_OFFSET, Y_OFFSET);       // left finger coordinates    630, 1020
                Utils.clickCoordinates(RIGHT_X_OFFSET, Y_OFFSET);      // right finger coordinates    930, 1020
                count--;
            }
            log.info("Double click is stopped");
            if (timeWaiter == true) {
                log.info("//////// Wait one hour ////////");
                clickAndWait(MINUTES_IN_HOUR, multitap);
                timeWaiter = false;
            } else if (countEnergy > 0 && timeWaiter == false) {
                log.info("Click boost button");
                clickerPage.getBoostButton().click(tap());
                clickerPage.getFullEnergy()
                        .shouldBe(visible)
                        .click(tap());
                log.info("Click energy button");
                clickerPage.getGoAheadEnergy()
                        .shouldBe(visible)
                        .click(tap());
                Utils.sleep(1500);
                timeWaiter = true;
                countEnergy--;
            } else {
                log.info("//////// Wait 24 hours ////////");
                clickAndWait(MINUTES_IN_DAY, multitap);
                countEnergy = fullEnergy;
            }
        }
    }

    private void clickAndWait(int min, int multitap) {
        log.info("Waiting for full energy button to activate");
        int waitTime = multitap / ENERGY_IN_SEC + ((multitap % ENERGY_IN_SEC == 0) ? 0 : 1);
        log.info("Waiting for the energy needed for one click to be restored: {} s", waitTime);
        int iter = (min * SECONDS_IN_MIN) / waitTime + (((min * SECONDS_IN_MIN) % waitTime == 0) ? 0 : 1);
        log.info("Number of clicks in a given time: {}", iter);
        int i = 0;
        while (true) {
            if (i >= iter) {
                log.info("//////// Stop waiting ////////");
                break;
            }
            Utils.clickCoordinates(MIDDLE_X_OFFSET, Y_OFFSET);
            Utils.sleep((long) waitTime * MS_IN_S);
            i += 1;
        }
    }
}
