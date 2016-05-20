package ru.niceone.youtube.tests

import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class LogInTest {

    private static
    final String SIGN_IN_YOUTUBE_BUTTON = "//button[@class='yt-uix-button yt-uix-button-size-default yt-uix-button-primary']"
    private static final String SIGN_IN_GOOGLE_BUTTON = "//input[@class='rc-button rc-button-submit']"

    private static final String ERR_MSG_SPAN = "//*[contains(@class,'error-msg')]"

    private static WebDriver driver

    @BeforeClass
    public static void init() {
        AutoProp.set()

        driver = new ChromeDriver()
    }

    @Test
    public void EmptyLogIn() {
        driver.navigate().to("http://youtube.com")
        driver.findElement(By.xpath(SIGN_IN_YOUTUBE_BUTTON)).click()
        driver.findElement(By.xpath(SIGN_IN_GOOGLE_BUTTON)).click()

        List<WebElement> list = driver.findElements(By.xpath(ERR_MSG_SPAN));
        Assert.assertTrue("Text not found!", list.size() > 0);
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
