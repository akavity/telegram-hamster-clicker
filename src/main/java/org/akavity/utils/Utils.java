package org.akavity.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {
    public static void sleepHours(long hour) {
        try {
            long mills = hour * 60 * 60 * 1000;
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleepMinutes(long min) {
        try {
            long mills = min * 60 * 1000;
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitUntilClickable(SelenideElement element) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofMillis(30000));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickCoordinates(int x, int y) {
        TouchAction touch = new TouchAction(AppiumDriverRunner.getAndroidDriver());
        touch.press(PointOption.point(x, y)).release().perform();
    }

    public static int extractIntegerFromText(String text, String regex) {
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group().replace(" /", "")
            );
        }
        return result;
    }
}
