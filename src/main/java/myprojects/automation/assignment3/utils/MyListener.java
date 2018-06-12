package myprojects.automation.assignment3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by Administrator on 6/12/2018.
 */
public class MyListener extends AbstractWebDriverEventListener {


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.print("Start to look for   " + by + "  ->->->->->->");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("\tFound " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on" + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Click on " + element + "has been done");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println(throwable);
    }
}

