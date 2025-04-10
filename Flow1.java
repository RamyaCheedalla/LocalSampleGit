package Started;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Flow1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();//launching the driver 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();//maximizing the window 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//set DOM wait 
		System.out.println("**********Creating new Category****************");
		
		
		//Login the application 
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement manage=driver.findElement(By.xpath("//span[text()='Manage']"));
		Actions actions = new Actions(driver);//hover on manage link
		actions.moveToElement(manage).perform();
		//clicking on manage categories
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		//Switch to tab 
		Set<String> s=driver.getWindowHandles();
		List<String> l6 = new ArrayList<String>(s);
		driver.close();
		driver.switchTo().window(l6.get(1));

		//Click on new category and adding it
		driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
		Alert a = driver.switchTo().alert();
		a.sendKeys("AWS");
		a.accept();
		//verify the list is added with new category 

		WebElement oldElement = driver.findElement(By.xpath("//tr//td[1]"));
		wait.until(ExpectedConditions.stalenessOf(oldElement));
		List<WebElement> l = driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement w :l)
		{
			if(w.getText().equals("AWS"))
			{
				System.out.println("*********Category is added***********");
				break;
			}



		}
		//Click on menu and sign out 
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();

		//click on sign up
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='interest-div']//label"));
		for(WebElement w1 :l1)
		{
			if(w1.getText().equals("AWS"))
			{
				System.out.println("*********Category is added on sign up page***********");
				break;
			}


		}
		Thread.sleep(100);
		driver.navigate().back();
		System.out.println("**********Updating new Category****************");
		//now update the category 
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10);
		WebElement manage1=driver.findElement(By.xpath("//span[text()='Manage']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(manage1).perform();
		//clicking on manage categories
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		//Switch to tab 
		Set<String> s7=driver.getWindowHandles();
		List<String> l7 = new ArrayList<String>(s7);
		driver.close();
		driver.switchTo().window(l7.get(1));
		Thread.sleep(10);
		WebElement update=driver.findElement(By.xpath("//td[text()='AWS']/..//following-sibling::td//button[text()='Update ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", update);
		Thread.sleep(30);
		Alert a1 = wait.until(ExpectedConditions.alertIsPresent());
		a1.sendKeys("Azure");
		a1.accept();

		oldElement = driver.findElement(By.xpath("//tr//td[1]"));
		wait.until(ExpectedConditions.stalenessOf(oldElement));
		List<WebElement> l3=driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement w2 :l3)
		{
			if(w2.getText().equals("Azure"))
			{
				System.out.println("*********Category is updated***********");
				break;
			}


		}
		//Click on menu and sign out 
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();

		//click on sign up
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		l1 = driver.findElements(By.xpath("//div[@class='interest-div']//label"));
		for(WebElement w1 :l1)
		{
			if(w1.getText().equals("Azure"))
			{
				System.out.println("*********Category is updated on sign up page***********");
				break;
			}


		}
		Thread.sleep(100);
		driver.navigate().back();
		System.out.println("**********Deleting the categor now****************");
		
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10);
		manage1=driver.findElement(By.xpath("//span[text()='Manage']"));
		actions1 = new Actions(driver);
		actions1.moveToElement(manage1).perform();
		//clicking on manage categories
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		//Switch to tab 
		s7=driver.getWindowHandles();
		l7 = new ArrayList<String>(s7);
		driver.close();
		driver.switchTo().window(l7.get(1));
		WebElement delete=driver.findElement(By.xpath("//td[text()='Azure']/..//following-sibling::td//button[text()='Delete ']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		oldElement = driver.findElement(By.xpath("//tr//td[1]"));
		wait.until(ExpectedConditions.stalenessOf(oldElement));
		l3=driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement w2 :l3)
		{
			if(w2.getText().equals("Azure"))
			{
				System.out.println("*********Category is not deleted***********");
				break;
			}
		}
		//Click on menu and sign out 
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();

		//click on sign up
		driver.findElement(By.xpath("//a[text()='New user? Signup']")).click();
		l1 = driver.findElements(By.xpath("//div[@class='interest-div']//label"));
		for(WebElement w1 :l1)
		{
			if(w1.getText().equals("Azure"))
			{
				System.out.println("*********Category is not deleteted***********");
				break;
			}


		}
		System.out.println("**********Category Deleted****************");
		
		driver.close();
	}
}
