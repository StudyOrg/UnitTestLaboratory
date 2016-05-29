package ru.niceone.youtube.tests

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SubscribeTest {
    private static final String SUBSCRIBE_BUTTON = "//div[contains(@class, 'primary-header-upper-section-wrapper')]/div/div[2]/div/span/button[1]"
    private static final String SUBSCRIBE_BUTTON_STR = "Подписаться"
    private static final String UNSUBSCRIBE_BUTTON_STR = "Подписка оформлена"

    private static final String NEW_CHANNEL =
            "//tr[contains(@class, 'subscription-item')]/td/div/div[@class='subscription-title-wrap']/span/span/span/a[contains(text(), 'Vevo')]"

    private static WebDriver driver

    private static void login() {
        driver.navigate().to(Links.mainPage)
        driver.findElement(By.xpath(LogInTest.SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(LogInTest.EMAIL_INPUT)).sendKeys("smirnovsg15")
        driver.findElement(By.xpath(LogInTest.NEXT_GOOGLE_BUTTON)).click()

        WebDriverWait wait = new WebDriverWait(driver, 1)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogInTest.PASSWD_INPUT)))

        driver.findElement(By.xpath(LogInTest.PASSWD_INPUT)).sendKeys("MARK2013ROME")
        driver.findElement(By.xpath(LogInTest.SIGN_IN_GOOGLE_BUTTON)).click()
    }

    @Before
    public void init() {
        AutoProp.set()
        driver = new ChromeDriver()
    }

    @Test
    public void subscribeTest() {
        login()
        driver.navigate().to(Links.exampleChannel)

        def button = driver.findElement(By.xpath(SUBSCRIBE_BUTTON))
        Assert.assertEquals(SUBSCRIBE_BUTTON_STR, button.getText())

        button.click()

        WebDriverWait wait = new WebDriverWait(driver, 2)
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(SUBSCRIBE_BUTTON), UNSUBSCRIBE_BUTTON_STR))

        Assert.assertEquals(UNSUBSCRIBE_BUTTON_STR, button.getText())

        driver.navigate().to(Links.subscriptionManager)

        List<WebElement> list = driver.findElements(By.xpath(NEW_CHANNEL))
        Assert.assertTrue("New channel not found!", list.size() > 0)
    }

    @Test
    public void unsubscribeTest() {
        login()
        driver.navigate().to(Links.exampleChannel)

        def button = driver.findElement(By.xpath(SUBSCRIBE_BUTTON))
        Assert.assertEquals(UNSUBSCRIBE_BUTTON_STR, button.getText())

        button.click()

        WebDriverWait wait = new WebDriverWait(driver, 2)
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(SUBSCRIBE_BUTTON), SUBSCRIBE_BUTTON_STR))

        Assert.assertEquals(SUBSCRIBE_BUTTON_STR, button.getText())

        driver.navigate().to(Links.subscriptionManager)

        List<WebElement> list = driver.findElements(By.xpath(NEW_CHANNEL))
        Assert.assertTrue("New channel not found!", list.size() == 0)
    }

    @After
    public void dest() {
        driver.close()
        driver.quit()
    }
}
