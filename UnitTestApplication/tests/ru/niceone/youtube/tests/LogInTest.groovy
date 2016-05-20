package ru.niceone.youtube.tests

import org.junit.Assert
import org.junit.Test
import org.openqa.selenium.*
import org.openqa.selenium.firefox.FirefoxDriver


class LogInTest {

    @Test
    public void EmptyLogIn() {
        WebDriver driver = new FirefoxDriver()

        driver.navigate().to("http://seleniumsimplified.com")
        //WebElement element = driver.findElement(By.className("yt-lockup-thumbnail contains-addto"))



        //Assert.assertTrue((element) ? true : false)

        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified"))

        driver.close()
        driver.quit()
    }
}
