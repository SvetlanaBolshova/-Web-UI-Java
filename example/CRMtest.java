package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.sql.DriverManager;

public class CRMtest {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       loginToCrm();
        Thread.sleep(5000);

        driver.get("https://crm.geekbrains.space/expense-request/ ");
        driver.findElement(By.xpath("//a[@title='Создать заявку на расход']")).click();
        //a[@ title="Создать заявку на расход"]
        Thread.sleep(5000);
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("Hello");
        //name="crm_expense_request[description]"
        Select businesUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        businesUnitSelect.selectByVisibleText("Research & Development");
        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        Select currencySelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
        currencySelect.selectByVisibleText("Доллар США");

        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("10000");

        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
        driver.findElement(By.xpath("//a[text()='20']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }


    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
        //id="prependedInput"
        //id="prependedInput2"
        //button
    }
}
