package org.BolshovaSVdz3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications")
                .addArguments("user-agent=Googlebot/2.1(+hhtp://www.google.com/bot.html");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
