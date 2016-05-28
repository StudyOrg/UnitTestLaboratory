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

class AccessTest {

    private static final String VIDEO_HEADER = "//span[@class='watch-title']"
    private static final String VIDEO_LIST_VFRAME = "//ul[contains(@class,'video-list')]/li[2]/div/a"
    private static final String VIDEO_PAGE_VFRAME = "//h3[contains(@class,'yt-lockup-title')]"

    private static WebDriver driver

    @BeforeClass
    public static void init() {
        AutoProp.set()

        driver = new ChromeDriver()
    }

    @Test
    public void access_from_main_page() {
        driver.navigate().to(Links.mainPage)
        WebElement link = driver.findElement(By.xpath(VIDEO_PAGE_VFRAME))
        String text = link.getText()

        WebDriverWait wait = new WebDriverWait(driver, 5)
        link.click()
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_HEADER)))

        Assert.assertEquals(text, driver.findElement(By.xpath(VIDEO_HEADER)).getText())
    }

    @Test
    public void access_from_video_watching() {
        driver.navigate().to(Links.exampleVideo)
        WebElement link = driver.findElement(By.xpath(VIDEO_LIST_VFRAME))
        String text = driver.findElement(By.xpath("$VIDEO_LIST_VFRAME/span[contains(@class, 'title')]")).getText()

        link.click()

        WebDriverWait wait = new WebDriverWait(driver, 5)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_HEADER)))

        Assert.assertEquals(text, driver.findElement(By.xpath(VIDEO_HEADER)).getText())
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
