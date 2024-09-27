package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Crawler {

    WebDriver webDriver;
    private final static By TEXTAREA = By.tagName("textarea");
    private final static By AUTO_COMPLETE_LIST_ELEMENT = By.cssSelector("li[data-attrid='AutocompletePrediction']");

    public Crawler(WebDriver driver){
        this.webDriver = driver;
    }

    public void execute(){
        webDriver.get("https://www.google.com");
        enterSearchTerm("What is the meaning of Life");
        wait5seconds();
        printAutoCompleteResult();
        webDriver.quit();

    }

    private void printAutoCompleteResult() {
        List<WebElement> elements = webDriver.findElements(AUTO_COMPLETE_LIST_ELEMENT);
        System.out.println("printout:");
        if(elements.isEmpty()){
            System.out.println("Not items found");
        }
        else{
            elements.forEach(item ->{
                System.out.println(item.getText());
            });

        }

    }

    private void wait5seconds() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
    }

    private void enterSearchTerm(String word) {
        List<WebElement> searchBarCandidates = webDriver.findElements(TEXTAREA);
        WebElement searchBar = searchBarCandidates
                .stream()
                .filter(element -> element.getAttribute("title").equals("Search"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Cannot find search bar"));

        searchBar.sendKeys(word);

    }
}
