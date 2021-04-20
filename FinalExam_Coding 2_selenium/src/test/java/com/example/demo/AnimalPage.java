package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalPage {

    @FindBy(id="animalText")
    private WebElement animalText;

    @FindBy(id="adjective")
    private WebElement adjectiveText;

    @FindBy(id="trainingMsg")
    private WebElement trainingMsg;

    @FindBy(id="submit-button")
    private WebElement submitButton;



    public AnimalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTrainingMsg(){
        return trainingMsg.getText();
    }

    public void submitAnimalNameNAdjective(String name, String adjective){
        animalText.sendKeys(name);
        adjectiveText.sendKeys(adjective);
        submitButton.click();
    }

}
