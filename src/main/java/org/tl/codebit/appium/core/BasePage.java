package org.tl.codebit.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.util.List;

import static org.tl.codebit.appium.core.DriverFactory.getDriver;

public class BasePage {

    public void write(By by, String text) throws MalformedURLException {
        getDriver().findElement(by).sendKeys(text);
    }

    public void writeByPlaceholder(String text, String msg) throws MalformedURLException {
        getDriver().findElement(By.xpath("//*[@text='"+text+"']")).sendKeys(msg);
    }

    public String getText(By by) throws MalformedURLException {
        return getDriver().findElement(by).getText();
    }

    public void click(By by) throws MalformedURLException {
         getDriver().findElement(by).click();
    }

    public void clickByText(String text) throws MalformedURLException {
        click(By.xpath("//*[@text='"+text+"']"));
    }

    public boolean thereIsElementByText(String text) throws MalformedURLException {
        //Existe o elmento por texto
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+text+"']"));
        return elementos.size() > 0;
    }

    public void tap(int x, int y) throws MalformedURLException {
        new TouchAction(getDriver()).press(PointOption.point(x, y)).perform();
    }

    public void scrollDown() throws MalformedURLException {
        scroll(0.9, 0.1);
    }

    public void scrollUp() throws MalformedURLException {
        scroll(0.1, 0.9);
    }

    public void swipRight() throws MalformedURLException {
        swipe(0.9,0.1);
    }

    public void swipLeft() throws MalformedURLException {
        swipe(0.1,0.9);
    }


    public void scroll(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width/2;
        int start_y =(int)(size.height * inicio);
        int end_y = (int)(size.height * fim);

        new TouchAction<>(getDriver())
                .longPress(PointOption.point(x, start_y))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }
    public void swipe(double inicio, double fim) throws MalformedURLException {
        Dimension size = getDriver().manage().window().getSize();
        int y = size.width/2;
        int start_y =(int)(size.width * inicio);
        int end_y = (int)(size.width * fim);

        new TouchAction<>(getDriver())
                .longPress(PointOption.point(start_y, y))
                .moveTo(PointOption.point(end_y, y))
                .release()
                .perform();

    }
    public void swipeElement(MobileElement element, double inicio, double fim) throws MalformedURLException {

        int y = element.getLocation().y + (element.getSize().height/2);
        int start_y =(int)(element.getSize().width * inicio);
        int end_y = (int)(element.getSize().width * fim);

        new TouchAction<>(getDriver())
                .longPress(PointOption.point(start_y, y))
                .moveTo(PointOption.point(end_y, y))
                .release()
                .perform();

    }


}
