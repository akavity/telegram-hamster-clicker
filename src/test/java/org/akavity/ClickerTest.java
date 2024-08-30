package org.akavity;

import org.akavity.steps.ClickerSteps;
import org.akavity.utils.Utils;
import org.testng.annotations.Test;

public class ClickerTest extends BaseTest {

    ClickerSteps clickerSteps = new ClickerSteps();

    @Test
    public void clickTest() {
        clickerSteps.clickHamsterChat();
        clickerSteps.clickPlayButton();
        Utils.sleep(6000);
        clickerSteps.clickStartButton();
        clickerSteps.clickHamMoney(10000, 6, 19);
    }
}
