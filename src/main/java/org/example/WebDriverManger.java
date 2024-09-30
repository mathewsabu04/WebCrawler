package org.example;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManger {

    private static WebDriver webDriver;

    public static WebDriver getDriver(){

        if(webDriver == null){
            ChromeOptions options = new ChromeOptions();
            webDriver = new ChromeDriver(options);

        }
        return  webDriver;

    }
}
