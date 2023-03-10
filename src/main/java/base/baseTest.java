package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Constants;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class baseTest {

    public static WebDriver driver;
    public static Properties prop;

    public baseTest() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setupBrowser(){
        String browser = prop.getProperty("browser");
        if (!browser.equalsIgnoreCase("chrome")) {
            System.out.println("Not Defined");
        } else {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));

    }
}