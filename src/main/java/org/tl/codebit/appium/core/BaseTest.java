package org.tl.codebit.appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void killClass(){
        DriverFactory.killDriver();
    }

    @After
    public void tearDown() throws IOException{
        takeScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    public void takeScreenShot() throws IOException {
        try {
            File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void funcWait(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
