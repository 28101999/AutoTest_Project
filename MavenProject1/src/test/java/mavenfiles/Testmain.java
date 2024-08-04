package mavenfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testmain {
    WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fitpeo.com");
    }
    
    @Test
    public void navigateToMenuItem() throws InterruptedException {
        driver.findElement(By.linkText("Revenue Calculator")).click();
        Thread.sleep(3000); 
    }
    
    @Test(dependsOnMethods = {"navigateToMenuItem"})
    public void scrollToMedicareEligiblePatients() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(3000);
    }
	
	@Test(dependsOnMethods = {"scrollToMedicareEligiblePatients"})
	//	    WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]"));
	//	    Actions action = new Actions(driver);
	//	    action.dragAndDropBy(slider, 820, 0).perform();
	//	    Thread.sleep(3000);
	    
	    
	public void setSliderToValue() throws InterruptedException {
        // Navigate to the appropriate page if needed
        driver.findElement(By.linkText("Revenue Calculator")).click();
        

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        setSliderValueUsingJS(slider, 820);

        String newValue = slider.getAttribute("value");
        System.out.println("Slider value is set to: " + newValue);
        
        Thread.sleep(3000);
    }

    public void setSliderValueUsingJS(WebElement slider, int value) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        int min = Integer.parseInt(slider.getAttribute("aria-valuemin"));
        int max = Integer.parseInt(slider.getAttribute("aria-valuemax"));
        int step = Integer.parseInt(slider.getAttribute("step"));
        
        int finalValue = Math.max(min, Math.min(max, value));

        js.executeScript("arguments[0].value = arguments[1];", slider, finalValue);
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", slider);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", slider); 
        
	    Thread.sleep(3000);
    }
    
    @Test(dependsOnMethods = {"selectCheckboxes"})
    public void selectCheckboxes() throws InterruptedException {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);
        
        String[] xpaths = {
            "/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input",
            "/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input",
            "/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input"
        };
        
        for (String xpath : xpaths) {
            WebElement checkbox = driver.findElement(By.xpath(xpath));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        Thread.sleep(5000);
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
