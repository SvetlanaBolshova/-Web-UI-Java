package org.BolshovaSVdz3.Mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginToMail();
        Yourself();

        Thread.sleep(10000);
        driver.quit();
    }

    public static void loginToMail() {
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("testov-02");
        driver.findElement(By.xpath("//select[@name='domain']")).click();
        driver.findElement(By.xpath("//option[@value='@bk.ru']")).click();
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        driver.findElement(By.xpath("//input[@id='saveauth']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ytrewq65432");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
    }

    public static void Yourself() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);


        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@compose-button__wrapper']")));
        driver.findElement(By.xpath("//span[@compose-button__wrapper']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Написать себе']")));
        driver.findElement(By.xpath("//span[text()='Написать себе']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Subject']")));
        driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("Привет!");

        driver.findElement(By.xpath("//span[text()='Отправить']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id='false']/span[text()='Отправить']")));
        driver.findElement(By.xpath("//button[@data-test-id='false']/span[text()='Отправить']")).click();
    }
}







