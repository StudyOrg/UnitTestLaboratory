package ru.niceone.youtube.tests

import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LoginTest {

    public static final String EMAIL_INPUT = "//input[@type='email' and @name='Email']"
    public static final String PASSWD_INPUT = "//input[@type='password' and @name='Passwd']"

    private static final String PROFILE_BUTTON = "//div[@id='yt-masthead-user']/span/button"

    public static final String SIGN_IN_YOUTUBE_BUTTON = "//button[@class='yt-uix-button yt-uix-button-size-default yt-uix-button-primary']"
    public static final String NEXT_GOOGLE_BUTTON = "//div[@class='slide-out ']/input[@type='submit']"
    public static final String SIGN_IN_GOOGLE_BUTTON = "//div[@class='slide-in']/input[@type='submit']"

    private static final String ERR_MSG_SPAN = "//span[contains(@class,'error-msg')]"

    private static WebDriver driver

    @BeforeClass
    public static void init() {
        AutoProp.set()
        driver = new ChromeDriver()
    }

    @Test
    public void find_signin_youtube_button() {
        driver.navigate().to(Links.mainPage)

        List<WebElement> list = driver.findElements(By.xpath(SIGN_IN_YOUTUBE_BUTTON));
        Assert.assertTrue("Button SignIn Youtube not found", list.size() > 0)
    }

    @Test
    public void find_next_google_button() {
        driver.navigate().to(Links.googleAccounts)

        List<WebElement> list = driver.findElements(By.xpath(NEXT_GOOGLE_BUTTON));
        Assert.assertTrue("Button SignIn Google Account not found", list.size() > 0)
    }

    @Test
    public void empty_login() {
        driver.navigate().to(Links.mainPage)

        driver.findElement(By.xpath(SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(NEXT_GOOGLE_BUTTON)).click()

        List<WebElement> list = driver.findElements(By.xpath(ERR_MSG_SPAN))
        Assert.assertTrue("Error message not found!", list.size() > 2)
    }

    @Test
    public void incorrect_login() {
        driver.navigate().to(Links.mainPage)
        driver.findElement(By.xpath(SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys("tcgvbhfsdf")
        driver.findElement(By.xpath(NEXT_GOOGLE_BUTTON)).click()

        List<WebElement> list = driver.findElements(By.xpath(ERR_MSG_SPAN))
        Assert.assertTrue("Error message not found!", list.size() > 2)
    }

    @Test
    public void correct_login() {
        driver.navigate().to(Links.mainPage)
        driver.findElement(By.xpath(SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys("smirnovsg15")
        driver.findElement(By.xpath(NEXT_GOOGLE_BUTTON)).click()

        WebDriverWait wait = new WebDriverWait(driver, 1)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWD_INPUT)))

        driver.findElement(By.xpath(PASSWD_INPUT)).sendKeys("MARK2013ROME")
        driver.findElement(By.xpath(SIGN_IN_GOOGLE_BUTTON)).click()

        List<WebElement> list = driver.findElements(By.xpath(ERR_MSG_SPAN))
        Assert.assertTrue("Error message not expected!", list.size() <= 2)

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROFILE_BUTTON)))

        list = driver.findElements(By.xpath(PROFILE_BUTTON))
        Assert.assertTrue("Avatar expected", list.size() == 1)

        list[0].click()
        driver.findElement(By.xpath("//a[@href='/logout']")).click()

        driver.close()
        driver.quit()

        driver = new ChromeDriver()
    }

    @Test
    public void incorrect_password() {
        driver.navigate().to(Links.mainPage)
        driver.findElement(By.xpath(SIGN_IN_YOUTUBE_BUTTON)).click()

        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys("smirnovsg15")
        driver.findElement(By.xpath(NEXT_GOOGLE_BUTTON)).click()

        WebDriverWait wait = new WebDriverWait(driver, 1)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWD_INPUT)))

        driver.findElement(By.xpath(PASSWD_INPUT)).sendKeys("1234567")
        driver.findElement(By.xpath(SIGN_IN_GOOGLE_BUTTON)).click()

        List<WebElement> list = driver.findElements(By.xpath(ERR_MSG_SPAN))
        Assert.assertTrue("Error message not expected!", list.size() > 2)
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
