package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumHook {

    public static AndroidDriver androidDriver = null;
    protected static WebDriverWait waitVar = null;

    public static void openApp() throws MalformedURLException {
        String connectionToServer = "http://127.0.0.1:4723/wd/hub";
        File file = new File("src/main/resources/Apks");
        File fileS = new File(file,"ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "LoneWolfEmulator");
        cap.setCapability(MobileCapabilityType.APP, fileS.getAbsolutePath());
        androidDriver = new AndroidDriver(new URL(connectionToServer), cap);
        waitVar = new WebDriverWait(androidDriver, 90);
    }

    public static void executeCommand(){
        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd /c dir");
            p.waitFor();
            BufferedReader reader=new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }


    public static void teardown(){
        androidDriver.quit();
    }

}
