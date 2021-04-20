package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumJUnitTest {
    @LocalServerPort
    private Integer port;
    private static WebDriver driver;

    private AnimalPage animal;

    @BeforeAll
    public static void beforeAll() {
//        setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
//        open browser at localhost:port/animal
        driver.get("http://localhost:" + port + "/animal");
        animal = new AnimalPage(driver);
    }

    @Test
    public void maintest () {
        // perform an automated test with
            // animal: dog
            // adjective: funny

        animal.submitAnimalNameNAdjective("dog", "funny");
        String result = animal.getTrainingMsg();

        assertEquals("We love funny dogs.", result);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
