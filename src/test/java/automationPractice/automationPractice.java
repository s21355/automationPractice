package automationPractice;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class automationPractice {
    private static WebDriver driver;
    private static WebDriver edgeDriver;


    @BeforeAll
    public static void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        options.addArguments("--start-maximized", "--headless");
        edgeOptions.addArguments("--start-maximized", "--headless");
        driver = new ChromeDriver(options);
        edgeDriver = new EdgeDriver(edgeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.get("http://automationpractice.pl/index.php");
        edgeDriver.get("http://automationpractice.pl/index.php");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
        edgeDriver.quit();
    }

    @Test
    public void testLogin()  {
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signIn.click();
        WebElement email = driver.findElement(By.id("email_create"));
        email.sendKeys("oepq42334@wp.pl");
        WebElement submitCreate = driver.findElement(By.id("SubmitCreate"));
        submitCreate.click();

        WebElement sex = driver.findElement(By.name("id_gender"));
        sex.click();


        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Dawid");
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Dawidowski");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("123456");

        Select drpDay = new Select(driver.findElement(By.name("days")));
        drpDay.selectByValue("5");
        Select drpMonth = new Select(driver.findElement(By.name("months")));
        drpMonth.selectByValue("3");
        Select drpYear = new Select(driver.findElement(By.name("years")));
        drpYear.selectByValue("1996");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("submitAccount")).click();
        String accountUrl = driver.getCurrentUrl();
        assertEquals("http://automationpractice.pl/index.php?controller=my-account",accountUrl);
    }

    @Test
    public void checkIfInCart()  {
        WebElement bestSellers = driver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a"));
        bestSellers.click();

        WebElement blouse = driver.findElement(By.xpath("//*[@title='Blouse']"));
        blouse.click();
        WebElement addCart = driver.findElement(By.name("Submit"));
        addCart.click();

        WebElement inCart = driver.findElement(By.xpath("//*[@title=\"Proceed to checkout\"]"));
        String okCart = inCart.getText();
        assertNotNull(okCart);

    }

    @Test
    public void sendMessage()  {
        WebElement bestSellers = driver.findElement(By.id("contact-link"));
        bestSellers.click();

        Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
        subjectHeading.selectByValue("2");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("witam@wp.pl");

        WebElement oderRef = driver.findElement(By.name("id_order"));
        oderRef.sendKeys("876123134013");

        WebElement message = driver.findElement(By.name("message"));
        message.sendKeys("Witam, proszę o zwrot lasu.");

        WebElement submitMessage = driver.findElement(By.id("submitMessage"));
        submitMessage.click();

        WebElement success = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));

        assertNotNull(success);

    }
//////////////////////////////////////////////////////
@Test
public void testLoginEdge()  {
    WebElement signIn = edgeDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
    signIn.click();
    WebElement email = edgeDriver.findElement(By.id("email_create"));
    email.sendKeys("oepq42331z@wp.pl");
    WebElement submitCreate = edgeDriver.findElement(By.id("SubmitCreate"));
    submitCreate.click();

    WebElement sex = edgeDriver.findElement(By.name("id_gender"));
    sex.click();


    WebElement firstName = edgeDriver.findElement(By.id("customer_firstname"));
    firstName.sendKeys("Dawid");
    WebElement lastName = edgeDriver.findElement(By.id("customer_lastname"));
    lastName.sendKeys("Dawidowski");
    WebElement password = edgeDriver.findElement(By.id("passwd"));
    password.sendKeys("123456");

    Select drpDay = new Select(edgeDriver.findElement(By.name("days")));
    drpDay.selectByValue("5");
    Select drpMonth = new Select(edgeDriver.findElement(By.name("months")));
    drpMonth.selectByValue("3");
    Select drpYear = new Select(edgeDriver.findElement(By.name("years")));
    drpYear.selectByValue("1996");
    edgeDriver.findElement(By.id("newsletter")).click();
    edgeDriver.findElement(By.id("submitAccount")).click();
    String accountUrl = edgeDriver.getCurrentUrl();
    assertEquals("http://automationpractice.pl/index.php?controller=my-account",accountUrl);
}

    @Test
    public void checkIfInCartEdge()  {
        WebElement bestSellers = edgeDriver.findElement(By.xpath("//*[@id=\"home-page-tabs\"]/li[2]/a"));
        bestSellers.click();

        WebElement blouse = edgeDriver.findElement(By.xpath("//*[@title='Blouse']"));
        blouse.click();
        WebElement addCart = edgeDriver.findElement(By.name("Submit"));
        addCart.click();

        WebElement inCart = edgeDriver.findElement(By.xpath("//*[@title=\"Proceed to checkout\"]"));
        String okCart = inCart.getText();
        assertNotNull(okCart);

    }

    @Test
    public void sendMessageEdge()  {
        WebElement bestSellers = edgeDriver.findElement(By.id("contact-link"));
        bestSellers.click();

        Select subjectHeading = new Select(edgeDriver.findElement(By.id("id_contact")));
        subjectHeading.selectByValue("2");

        WebElement email = edgeDriver.findElement(By.id("email"));
        email.sendKeys("witam@wp.pl");

        WebElement oderRef = edgeDriver.findElement(By.name("id_order"));
        oderRef.sendKeys("876123134013");

        WebElement message = edgeDriver.findElement(By.name("message"));
        message.sendKeys("Witam, proszę o zwrot lasu.");

        WebElement submitMessage = edgeDriver.findElement(By.id("submitMessage"));
        submitMessage.click();

        WebElement success = edgeDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));

        assertNotNull(success);
    }
}
