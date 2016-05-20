package ru.niceone.youtube.tests

import org.junit.Assert
import org.junit.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class LogInTest {

    @Test
    public void EmptyLogIn() {
        System.setProperty("webdriver.chrome.driver", "c:/bin/selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver()

        driver.navigate().to("http://seleniumsimplified.com")
        //WebElement element = driver.findElement(By.className("yt-lockup-thumbnail contains-addto"))



        //Assert.assertTrue((element) ? true : false)

        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified"))

        driver.close()
        driver.quit()
    }
}
