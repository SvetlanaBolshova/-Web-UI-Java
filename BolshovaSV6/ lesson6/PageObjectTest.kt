package BolshovaSV6.` lesson6`

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

import static org.hamcrest.MatcherAssert.assertThat;
import ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed


class PageObjectTest : BaseTest() {
    @Test
    @kotlin.Throws(InterruptedException::class)
    fun loginInCrmWithPageObjTest() {
        driver.get("https://crm.geekbrains.space/")
        LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton().navigationMenu.openNavigationMenuItem("Расходы")
        ExpensesSubMenu(driver).goToExpensesRequestsPage()
        ExpensesRequestsPage(driver)
                .createExpense()
                .fillName("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectCurrency("Доллар США")
                .fillSumPlan("1000")
                .selectDatePlan("20").saveAndCloseButton.click()
        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")))
        assertThat(CreateExpensePage(driver).requestSavedSuccessfullyElement, isDisplayed())
    }
}