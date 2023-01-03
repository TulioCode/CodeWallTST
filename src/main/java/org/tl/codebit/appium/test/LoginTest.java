package org.tl.codebit.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tl.codebit.appium.core.BaseTest;
import org.tl.codebit.appium.page.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {

    private LoginPage page = new LoginPage();

    @Before
    public void initialize() throws MalformedURLException, InterruptedException{
        page.passInitialBanner();
        page.writeEmail("tulio@codebit.com.br");
        page.writePassword("Codebit@123");
        page.clickRealizeLogin();
    }

    @Test
    public void login() throws MalformedURLException, InterruptedException {
        page.clickToDevices();
        Thread.sleep(1500);
        Assert.assertEquals("Aparelhos", page.takeTitlePageDevices());
        page.scrollDown();
        Thread.sleep(500);
        page.clickDeviceNoIdentification(1315, 1455);
    }
}
