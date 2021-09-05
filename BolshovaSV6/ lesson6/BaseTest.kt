package BolshovaSV6.` lesson6`

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait

class BaseTest {
    var driver: WebDriver? = null
    var webDriverWait: WebDriverWait? = null
    @BeforeEach
    fun initDriver() {
        driver = ChromeDriver()
        webDriverWait = WebDriverWait(driver, 5)
    }

    @AfterEach
    fun tearDown() {
        driver!!.quit()
    }

    companion object {
        @BeforeAll
        fun registerDriver() {
            WebDriverManager.chromedriver().setup()
        }
    }
}