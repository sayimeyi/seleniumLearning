package com.learn.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	private static ChromeDriver browser;
	
	@BeforeClass
    public static void openBrowser() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","C:/tool/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }
    
    
    @Test
    public void testUntitledTestCase() throws Exception {
    	browser.get("https://www.baidu.com/");
    	browser.findElement(By.id("kw")).clear();
    	browser.findElement(By.id("kw")).sendKeys("Accenture");
    	browser.findElement(By.id("form")).submit();
        System.out.println("----over---");
    }


}
