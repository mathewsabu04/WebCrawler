package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Crawler {



    private final static By TEXTAREA = By.tagName("textarea");
    private final static By AUTO_COMPLETE_LIST_ELEMENT = By.cssSelector("li[data-attrid='AutocompletePrediction']");
    private WebDriver webDriver;


    public Crawler(){
        this.webDriver = WebDriverManger.getDriver();

    }



    public void navigateToGoogle(){
        webDriver.get("https://www.google.com");
    }

    public List<String> getAutoCompleteResults() {
        waitUntilVisible();
        return  webDriver
                .findElements(AUTO_COMPLETE_LIST_ELEMENT)
                .stream()
                .map(item->item.getText())
                .collect(Collectors.toList());

    }

    private void waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AUTO_COMPLETE_LIST_ELEMENT));
    }

    public void enterSearchTerm(String word)
    {
        List<WebElement> searchBarCandidates = webDriver.findElements(TEXTAREA);
        WebElement searchBar = searchBarCandidates
                .stream()
                .filter(element -> element.getAttribute("title").equals("Search"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Cannot find search bar"));

        searchBar.sendKeys(word);

    }
}
