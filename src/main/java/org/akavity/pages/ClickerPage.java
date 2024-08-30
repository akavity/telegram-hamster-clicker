package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ClickerPage {
    private final SelenideAppiumCollection hamsterChats = $$(AppiumBy.xpath("//android.view.ViewGroup"));
    private final SelenideAppiumCollection playButtons = $$(AppiumBy.xpath("//android.widget.Button[contains(@text,'Играть в 1 клик')]"));
    private final SelenideAppiumElement startButton = $(AppiumBy.xpath("//android.widget.Button[@text='Thank you, BingX']"));
    private final SelenideAppiumElement energyField = $(AppiumBy.xpath("//android.widget.TextView[contains(@text,' / 10000')]"));
    private final SelenideAppiumElement boostButton = $(AppiumBy.xpath("//android.view.View[@content-desc='Boost Boost']"));
    private final SelenideAppiumElement fullEnergy = $(AppiumBy.xpath("//android.widget.TextView[@text='Full energy']/.."));
    private final SelenideAppiumElement goAheadEnergy = $(AppiumBy.xpath("//android.widget.Button[@text='Go ahead']"));
    private final SelenideAppiumElement hamsterButton = $(AppiumBy.xpath("//android.view.View[@content-desc='Exchange']"));

    public SelenideAppiumCollection getHamsterChats() {
        return hamsterChats;
    }

    public SelenideAppiumCollection getPlayButtons() {
        return playButtons;
    }

    public SelenideAppiumElement getStartButton() {
        return startButton;
    }

    public SelenideAppiumElement getEnergyField() {
        return energyField;
    }

    public SelenideAppiumElement getBoostButton() {
        return boostButton;
    }

    public SelenideAppiumElement getFullEnergy() {
        return fullEnergy;
    }

    public SelenideAppiumElement getGoAheadEnergy() {
        return goAheadEnergy;
    }

    public SelenideAppiumElement getHamsterButton() {
        return hamsterButton;
    }
}
