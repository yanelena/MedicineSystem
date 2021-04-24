package SeleniumTest;



import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {

    static WebDriver driver;

    @BeforeAll
    static void start() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Алена/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    @Order(1)
    void singInNurseTest() {
        driver.get("http://localhost:3000/login");
        WebElement username = driver.findElement(By.xpath("template/div/form/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("template/div/form/div[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        username.sendKeys("nurse");//проверка медсестры
        password.sendKeys("999999");
        submitButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("http://localhost:3000/medicine", driver.getCurrentUrl());
    }
    @Test
    @Order(2)
    void singInHeadTest() {
        driver.get("http://localhost:3000/login");
        WebElement username = driver.findElement(By.xpath("template/div/form/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("template/div/form/div[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        username.sendKeys("head");//проверка главы
        password.sendKeys("999999");
        submitButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("http://localhost:3000/medicinelist", driver.getCurrentUrl());
    }
    @Test
    @Order(3)
    void singInErrorTest() {
        driver.get("http://localhost:3000/login");
        WebElement username = driver.findElement(By.xpath("template/div/form/div[1]/input"));
        WebElement password = driver.findElement(By.xpath("template/div/form/div[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        username.sendKeys("gdsd");//проверка главы
        password.sendKeys("098");
        submitButton.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals("Неверный логин или пароль!!!", driver.getTitle());
    }

}

