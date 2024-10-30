package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseClass {
	
 public static WebDriver driver;
public Properties p;


	
	@BeforeClass (groups = {"Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		//Loading details from config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		System.out.println("hello feature2");
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("Mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else  {
			System.out.println("no matching browser");
			return;
			}
			switch  (br.toLowerCase()){
			
			case "chrome" :capabilities.setBrowserName("chrome");break;
			case "edge" :capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox" :capabilities.setBrowserName("firefox");break;
			default : System.out.println("Invalid browser name");return;
			}
			
			 driver = new RemoteWebDriver(new URL("http://10.0.0.142:4444/wd/hub"), capabilities);	
		
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		
		switch  (br.toLowerCase()){
		
		case "chrome" :driver =new ChromeDriver();break;
		case"firefox" :driver = new FirefoxDriver();break;
		case "edge" :driver = new EdgeDriver();break;
		default : System.out.println("Invalid browser name");return;
		
		}}
	driver.manage().deleteAllCookies();
	driver.get(p.getProperty("url"));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}

	@AfterClass(groups = {"Sanity","Regression"})
	public void shutdown() {
		
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		System.out.println(generatedString.toUpperCase());
		return generatedString;
		
	}
	public String randomenumber() {
		String generatednumber = RandomStringUtils.randomNumeric(3);
		System.out.println(generatednumber.toUpperCase());
		return generatednumber;
	}
	public String randomeStringpassword() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(4);
		String generatednumber1 = RandomStringUtils.randomNumeric(3);
		System.out.println(generatedString1 +"@"+generatednumber1);
		return generatedString1 +"@"+generatednumber1;
		
	}
	
	public  String captureScreen(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		TakesScreenshot takesScreenShot =(TakesScreenshot) driver;
		File sourcefile =takesScreenShot.getScreenshotAs(OutputType.FILE);
		
			String targetfilepath = System.getProperty("user.dir")+"\\screenshots\\" + tname +"_"+timestamp;
			File targetFile = new File(targetfilepath);
			sourcefile.renameTo(targetFile);
		
		return targetfilepath;
		
		
		
	}
	
	
}
