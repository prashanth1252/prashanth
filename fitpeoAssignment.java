package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class fitpeoAssignment {

    public static void main(String[] args) {
       
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thigu\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe"); // Update the path

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            driver.get("https://fitpeo.com"); 
            driver.manage().window().maximize();

            WebElement revenueCalculatorLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
            revenueCalculatorLink.click();

            WebElement sliderSection = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='range']) [1]"))); 
            actions.moveToElement(sliderSection).perform();

            WebElement slider = driver.findElement(By.xpath("(//input[@type='range']) [1]")); 
            actions.clickAndHold(slider).moveByOffset(94, 0).release().perform(); 
            

    
            Thread.sleep(1000); 

            WebElement sliderValue = driver.findElement(By.xpath("(//input[@type='range']) [1]")); 
            String currentSliderValue = sliderValue.getAttribute("value");
            if (!currentSliderValue.equals("823")) {
                throw new AssertionError("Slider value is incorrect. Expected: 823, Found: " + currentSliderValue);
            }
            

            WebElement textField = driver.findElement(By.xpath("(//input[@type='range']) [1]")); 
            textField.clear();
            textField.sendKeys("560");
            textField.sendKeys(org.openqa.selenium.Keys.RETURN);

            String updatedSliderValue = slider.getAttribute("560");
            if (!updatedSliderValue.equals("560")) {
                throw new AssertionError("Slider did not update correctly. Expected: 560, Found: " + updatedSliderValue);
            }

            String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
            for (String code : cptCodes) {
                WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox']) [1]")); 
               if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }

            WebElement reimbursementHeader = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]")); 
            String reimbursementValue = reimbursementHeader.getText();
            if (!reimbursementValue.equals("$110700")) {
                throw new AssertionError("Reimbursement value is incorrect. Expected: $110700, Found: " + reimbursementValue);
            }

            System.out.println("All test cases passed successfully!");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            
            if (driver != null) {
                driver.quit();
            }
        } 
    } 
}
