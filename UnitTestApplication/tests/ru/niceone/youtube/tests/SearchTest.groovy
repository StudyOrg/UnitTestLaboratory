package ru.niceone.youtube.tests

import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class SearchTest {

    private static final String SEARCH_TEXT_FIELD = "//*[@id=\"masthead-search-term\"]"
    private static final String SEARCH_BUTTON = "//*[@id=\"search-btn\"]"
    private static final String SEARCH_RESULTS_BLOCK = "//*[@id=\"results\"]"

    private static WebDriver driver

    @BeforeClass
    public static void init() {
        AutoProp.set()

        driver = new ChromeDriver()
    }

    @Test
    public void test_search_by_query() {
        final String query = "Evolution of dance"

        driver.navigate().to("http://youtube.com")
        driver.findElement(By.xpath(SEARCH_TEXT_FIELD)).sendKeys(query)
        driver.findElement(By.xpath(SEARCH_BUTTON)).click()

        driver.findElement(By.xpath(SEARCH_RESULTS_BLOCK))

        Assert.assertEquals(query + " - YouTube", driver.getTitle())
    }

    @AfterClass
    public static void dest() {
        driver.close()
        driver.quit()
    }
}
