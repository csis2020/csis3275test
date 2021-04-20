package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        // setup Webdriver and open a Chrome browser at localhost:8080/animal

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        AnimalPage animal = new AnimalPage(driver);

        //find the fields we want by id and fill them in
        // animal: dog
        // adjective: funny

        animal.submitAnimalNameNAdjective("dog", "funny");

        // close the browser after 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}