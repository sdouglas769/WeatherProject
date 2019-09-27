package Expleo.testcases;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccuWeatherForecast {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //URLS
    private String accuBaseUrl;
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
        accuBaseUrl = "https://www.accuweather.com";
        driver.get(accuBaseUrl);

//        String expectedURL = "www.accuweather.com";
//        String expectedTitle = "??????";
//        String actualTitle = driver.getTitle();
//        String actualURL = driver.getCurrentUrl();
//        System.out.println("Actual URL is: " + actualURL);
//        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testGetMaxMinTemps() throws Exception {
        driver.get(accuBaseUrl);
        //Search textbox
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input")).sendKeys("Paarl, Western Cape, ZA");
        //Press enter on search textbox
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //Click Daily link
        driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[3]/a[4]")).click();

        //print max and min temp for today day 1
        maxTempDay1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText();
        System.out.println("MAX temp today: " + maxTempDay1);
        minTempDay1 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText();
        System.out.println("MIN temp today: " + minTempDay1);

        //print max and min temp for day 2
        maxTempDay2 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText();
        System.out.println("MAX temp day 2: " + maxTempDay2);
        minTempDay2 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText();
        System.out.println("MIN temp day 2: " + minTempDay2);

        //print max and min temp for day 3
        maxTempDay3 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText();
        System.out.println("MAX temp day 3: " + maxTempDay3);
        minTempDay3 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText();
        System.out.println("MIN temp day 3: " + minTempDay3);

        //print max and min temp for day 4
        maxTempDay4 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[1]/div[2]/span[1]")).getText();
        System.out.println("MAX temp day 4: " + maxTempDay4);
        minTempDay4 = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[3]/a[1]/div[2]/span[2]")).getText();
        System.out.println("MIN temp day 4: " + minTempDay4);



//        driver.findElement(By.linkText("Register")).click();
//        driver.findElement(By.id("UserName")).sendKeys("ws12");
//        driver.findElement(By.id("Email")).sendKeys("ws01@netactive.co.za");
//        driver.findElement(By.id("Password")).sendKeys("abcdef");
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("abcdef");
//        driver.findElement(By.xpath(".//*[@id='main']/form/div[2]/fieldset/p/input")).click();

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
