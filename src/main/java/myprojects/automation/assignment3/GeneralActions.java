package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     *
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        // ...
        wait.until(ExpectedConditions.titleContains("prestashop-automation > Панель администратора (PrestaShop™)"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
        wait.until(ExpectedConditions.titleIs("Dashboard • prestashop-automation"));
        waitForContentLoad();
        //throw new UnsupportedOperationException();
    }


    /**
     * Adds new category in Admin Panel.
     *
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        // TODO implement logic for new category creation
        Actions actions = new Actions(this.driver);
        //opening of category page
        WebElement categoryPanel = driver.findElement(By.xpath("//li[@id='subtab-AdminCategories']/a"));

        actions.moveToElement(driver.findElement(By.xpath("//li[@id='subtab-AdminCatalog']/a"))).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='subtab-AdminCategories']/a")));
        driver.findElement(By.xpath("//li[@id='subtab-AdminCategories']/a")).click();
        wait.until(ExpectedConditions.titleIs("категории • prestashop-automation"));
        waitForContentLoad();

        //opening of new category page
        driver.findElement(By.xpath("//a[@id='page-header-desc-category-new_category']/i")).click();
        wait.until(ExpectedConditions.titleIs("категории > Добавить • prestashop-automation"));
        waitForContentLoad();

        //adding new catogory
        driver.findElement(By.id("name_1")).sendKeys(categoryName);
        driver.findElement(By.id("category_form_submit_btn")).click();
        wait.until(ExpectedConditions.titleIs("категории • prestashop-automation"));
        waitForContentLoad();

        //verifying new added category
        driver.findElement(By.xpath("//input[@name='categoryFilter_name']")).sendKeys(categoryName);
        driver.findElement(By.id("submitFilterButtoncategory")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[@id='table-category']/tbody/tr[1]/td[3]"), categoryName));

        //closing of driver
        driver.quit();

        //throw new UnsupportedOperationException();
    }


    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@id='ajax_running']"))));
        } catch (NoSuchElementException e) {

        }
        // ...
    }

}
