package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	//this class will have all the common methods to be used by all the testcase classes
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
	//Loading properties file
		
	FileReader file=new FileReader("./src//test//resources//config.properties");
	p=new Properties();
	p.load(file);// loading properties file.
		
	logger=LogManager.getLogger(this.getClass());// Initializing log4j2 log file
	
	//remote environment- Grid
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			
			{
		      DesiredCapabilities cap=new DesiredCapabilities();
		      //os
		      switch(os.toLowerCase())
		      
		      {
		      case "windows":cap.setPlatform(Platform.WIN11);
		            break;
		      case "mac":cap.setPlatform(Platform.MAC);
		            break;
		      case "linux":cap.setPlatform(Platform.LINUX);
		             break;
		      default:System.out.println("os dont match");
		            return;
		      
		      
		      }
		      
		      //browser
              switch(br.toLowerCase())
		      
		      {
		      case "chrome":cap.setBrowserName("chrome");
		            break;
		      case "edge":cap.setBrowserName("MicrosoftEdge");
		            break;
		      case "firefox":cap.setBrowserName("Firefox");
		             break;
		      default:System.out.println("invalid browser");
		            return;
		      }
		/*
		 * The URL(String) constructor in Java has been deprecated in recent 
		 * Java versions due to potential security risks and 
		 * limitations in handling complex URLs. 
		 * This deprecation is a proactive measure to encourage developers 
		 * to use more robust and secure methods for constructing URLs.
		 * 
		 *  so insteadof using ULR url=new URL("http://192.168.125.211:4444") we used below statement
		 */
              URI uri = URI.create("http://192.168.125.211:4444");
              URL url = uri.toURL();
		driver=new RemoteWebDriver(url,cap);//for assigning driver to grid 
		
			}
	
	//for local environment
	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
	
	switch (br.toLowerCase()) //used for parameterization for multiple web browser
	  {
	case "chrome": driver=new ChromeDriver();break;		
	case "edge": driver=new EdgeDriver();break;	
	case "firefox": driver=new FirefoxDriver();break;	
	
	default:System.out.println("invalid browser");return;
		
	   }
	}	
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.get(p.getProperty("appURL"));//reading url from properties file
	 driver.manage().window().maximize();
	 
	
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	public void teardown()
	{
		driver.close();
	}
	
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(10);
		return generatedString;
		
	}
	
	public String randomeNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
		
		
	}
	
	public String randomeAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		String generatedNumber=RandomStringUtils.randomNumeric(4);
		String genertedAlphaNumeric=generatedString+"@"+generatedNumber;
		return genertedAlphaNumeric;
		
	}
	
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}
	
	
	

}
