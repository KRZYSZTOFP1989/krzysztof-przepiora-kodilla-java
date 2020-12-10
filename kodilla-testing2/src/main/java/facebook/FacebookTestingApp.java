package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_BUTTON_COOKIES = "//button[2]";
    public static final String XPATH_BUTTON_REGISTER = "//div[contains(@class, \"_6ltg\")]/a[contains(@class, \"_4jy2\")]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement buttonCookies = driver.findElement(By.xpath(XPATH_BUTTON_COOKIES));
        buttonCookies.click();

        WebElement buttonRegister = driver.findElement(By.xpath(XPATH_BUTTON_REGISTER));
        buttonRegister.click();

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select select1 = new Select(selectMonth);
        select1.selectByIndex(8);

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select select2 = new Select(selectDay);
        select2.selectByIndex(7);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select select3 = new Select(selectYear);
        select3.selectByIndex(1989);

    }

}
