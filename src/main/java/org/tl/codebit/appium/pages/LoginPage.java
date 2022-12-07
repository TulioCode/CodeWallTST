package org.tl.codebit.appium.pages;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tl.codebit.appium.core.BasePage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.tl.codebit.appium.core.DriverFactory.getDriver;


public class LoginPage extends BasePage {

    public void passInitialBanner() throws MalformedURLException, InterruptedException {
        Thread.sleep(2000);
        swipeElement( getDriver().findElement(By.className("android.widget.ImageView")), 0.9, 0.1);
        click(By.className("android.widget.Button"));
    }


    public void writeEmail(String email) throws MalformedURLException {
        writeByPlaceholder("Digite seu e-mail", email);
    }
    public void writePassword(String senha) throws MalformedURLException {
        writeByPlaceholder("Digite sua senha", senha);
    }
}
