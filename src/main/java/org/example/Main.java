package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/mathewsabu/Downloads/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        new Crawler(driver).execute();
    }
}