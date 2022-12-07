package org.tl.codebit.appium.test;

import org.junit.Test;
import org.tl.codebit.appium.core.BaseTest;
import org.tl.codebit.appium.pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {

        private LoginPage page = new LoginPage();

    @Test
    public void login() throws MalformedURLException, InterruptedException {
        page.passInitialBanner();
        page.writeEmail("tulio@codebit.com.br");
        page.writePassword("Codebit@123");
    }
}
