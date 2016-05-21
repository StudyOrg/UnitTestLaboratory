package ru.niceone.youtube.tests

import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

class SearchTest {

    private static final String SEARCH_TEXT_FIELD = "//*[@id=\"masthead-search-term\"]"
    private static final String SEARCH_BUTTON = "//*[@id=\"search-btn\"]"
    private static final String SEARCH_RESULTS_BLOCK = "//*[@id=\"results\"]"
    private static
    final String VIDEO_PREVIEW_TITLE = "//*[@class=\"item-section\"]/li[1]/div/div/div[@class=\"yt-lockup-content\"]/h3/a"
    private static
    final String VIDEO_NOT_FOUND_BLOCK = "//*[@id=\"content\"]/div/div/div/div[1]/div/div[2]/div/ol/li[2]/ol/li/div"

    private static final String QUERY = "Evolution of Dance"
    private static final String BAD_QUERY = "dasdrcvxcsdfwercvwerw"

    private static WebDriver driver

    private static void search(String q) {
        driver.navigate().to("http://youtube.com")
        driver.findElement(By.xpath(SEARCH_TEXT_FIELD)).sendKeys(q)
        driver.findElement(By.xpath(SEARCH_BUTTON)).click()
    }

    @BeforeClass
    public static void init() {
        AutoProp.set()

        driver = new ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @Test
    public void correct_title() {
        search(QUERY)
        driver.findElement(By.xpath(SEARCH_RESULTS_BLOCK))

        Assert.assertEquals(QUERY + " - YouTube", driver.getTitle())
    }

    @Test
    public void queried_video_founded() {
        search(QUERY)

        String title = driver.findElement(By.xpath(VIDEO_PREVIEW_TITLE)).getText()

        Assert.assertEquals(QUERY, title)
    }

    @Test
    public void bad_query_video_not_found() {
        search(BAD_QUERY)

        String msg = driver.findElement(By.xpath(VIDEO_NOT_FOUND_BLOCK)).getText()

        Assert.assertEquals("Нет результатов по запросу ${BAD_QUERY}.".toString(), msg)
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
