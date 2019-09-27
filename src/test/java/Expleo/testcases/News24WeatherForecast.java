package Expleo.testcases;

import java.util.concurrent.TimeUnit;

import Expleo.pageobjects.News24FindMinMaxWeather;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class News24WeatherForecast {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //URLS
    private String news24BaseUrl;
    //private String news24BaseUrl;

    //Min Max Temp variables
    private String maxTempDay1;
    private String minTempDay1;
    private String maxTempDay2;
    private String minTempDay2;
    private String maxTempDay3;
    private String minTempDay3;
    private String maxTempDay4;
    private String minTempDay4;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        news24BaseUrl = "http://weather.news24.com";
        driver.get(news24BaseUrl);
    }

    @Test
    public void testGetMaxMinTemps() throws Exception {
        driver.get(news24BaseUrl);

        // Use PageObject News24FindMinMaxWeather
        News24FindMinMaxWeather findMinMax = PageFactory.initElements
                (driver, News24FindMinMaxWeather.class);

        //click dropdown and click city Paarl. then click Go button
        driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]/option[64]")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]")).click(); //go button

        driver.findElement(By.xpath("//*[@id=\"ext-gen28\"]")).click(); //7 Day Expanded forcast

        Thread.sleep(3000);

        //print max and min temp for today day 1
        maxTempDay1 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        System.out.println("News24 MAX temp today: " + maxTempDay1);
        minTempDay1 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();
        System.out.println("News24 MIN temp today: " + minTempDay1);

        // Store temperatures as strings in pageObject
        findMinMax.setMaxDay1(maxTempDay1);
        findMinMax.setMaxDay1(minTempDay1);

        //print max and min temp for day 2
        maxTempDay2 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getText();
        System.out.println("News24 MAX temp day2: " + maxTempDay2);
        minTempDay2 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getText();
        System.out.println("News24 MIN temp day2: " + minTempDay2);

        // Store temps as strings in pageObject
        findMinMax.setMaxDay1(maxTempDay2);
        findMinMax.setMaxDay1(minTempDay2);

        //print max and min temp for day 3
        maxTempDay3 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getText();
        System.out.println("News24 MAX temp day3: " + maxTempDay3);
        minTempDay3 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getText();
        System.out.println("News24 MIN temp day3: " + minTempDay3);

        // Store temps as strings in pageObject
        findMinMax.setMaxDay1(maxTempDay3);
        findMinMax.setMaxDay1(minTempDay3);

        //print max and min temp for day 4
        maxTempDay4 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getText();
        System.out.println("News24 MAX temp day4: " + maxTempDay4);
        minTempDay4 = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getText();
        System.out.println("News24 MIN temp day4: " + minTempDay4);

        // Store temps as strings in pageObject
        findMinMax.setMaxDay1(maxTempDay4);
        findMinMax.setMaxDay1(minTempDay4);
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
