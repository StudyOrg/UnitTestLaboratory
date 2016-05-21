package ru.niceone.youtube.tests

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


class LikesTest {
    private static final String LIKE_BUTTON = "//span[contains(@class,'like-button-renderer')]/span/button[not(contains(@class,'hid'))]"

    private static WebDriver driver

    @BeforeClass
    public static void init() {
        AutoProp.set()
        driver = new ChromeDriver()

        driver.navigate().to(Links.mainPage)
        driver.findElement(By.xpath(LogInTest.SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(LogInTest.EMAIL_INPUT)).sendKeys("smirnovsg15")
        driver.findElement(By.xpath(LogInTest.NEXT_GOOGLE_BUTTON)).click()

        WebDriverWait wait = new WebDriverWait(driver, 1)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogInTest.PASSWD_INPUT)))

        driver.findElement(By.xpath(LogInTest.PASSWD_INPUT)).sendKeys("MARK2013ROME")
        driver.findElement(By.xpath(LogInTest.SIGN_IN_GOOGLE_BUTTON)).click()
    }

    @Test
    public void likeVideo() {
        driver.navigate().to(Links.exampleVideo)

        List<WebElement> test = driver.findElements(By.xpath(LIKE_BUTTON))
        def a = "a"
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
