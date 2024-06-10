
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestProject3 {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void Setup() {

		String Theurl = "https://www.saucedemo.com/";

		driver.manage().window().maximize();
		driver.get(Theurl);
	}

	@Test(priority = 1)

	public void Login() {

		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));

		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();

	}

	// Is the word Products in the title present
	@Test(priority = 2)

	public void TestTitle() {

		WebElement TheMainName = driver.findElement(By.xpath("//span[@data-test='title']"));

		boolean ExpectedMainName = true;

		boolean ActualMainName = TheMainName.isDisplayed();
		Assert.assertEquals(ActualMainName, ExpectedMainName);

	}

	// Arrange items from lowest to highest by price
	@Test(priority = 3)

	public void TestSortFromeLowtohigh() throws InterruptedException {

		Thread.sleep(2000);

		WebElement Sortitem = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));

		Select myselector = new Select(Sortitem);

		myselector.selectByVisibleText("Price (low to high)");
	}

	@Test(priority = 4) // Make sure that the lowest price is the lowest among the prices

	public void VerifiyLowestPrice() throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> theprices = driver.findElements(By.className("inventory_item_price"));

		String Highprice = theprices.get(theprices.size() - 1).getText().replace("$", "");
		String LowestPrice = theprices.get(0).getText().replace("$", "");

		double TheHighPrice = Double.parseDouble(Highprice);
		double ThelowestPrice = Double.parseDouble(LowestPrice);

		Assert.assertEquals(TheHighPrice > ThelowestPrice, true);

	}

	@Test(priority = 5) // Arranging items from A to Z and retrieving the last item
	public void DropList() throws InterruptedException {
		Thread.sleep(2000);

		WebElement DropSort = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));

		Select Seloption = new Select(DropSort);
		Seloption.selectByVisibleText("Name (A to Z)");

		String ExpectedlastName = "Test.allTheThings() T-Shirt (Red)";

		List<WebElement> Lastnamepr = driver.findElements(By.className("inventory_item_name"));

		String Actuallastpr = Lastnamepr.get(Lastnamepr.size() - 1).getText();
		Assert.assertEquals(Actuallastpr, ExpectedlastName);

	}

	@Test(priority = 6) // Arranging items from Z to A and retrieving the last item
	public void SortNameZtoA() throws InterruptedException {
		Thread.sleep(2000);

		WebElement DropSort1 = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));

		Select Seloption1 = new Select(DropSort1);
		Seloption1.selectByVisibleText("Name (Z to A)");
		String ExpectedlastName1 = "Sauce Labs Backpack";
		List<WebElement> Lastnampr1 = driver.findElements(By.className("inventory_item_name"));
		String Actuallastpr1 = Lastnampr1.get(Lastnampr1.size() - 1).getText();
		Assert.assertEquals(Actuallastpr1, ExpectedlastName1);

	}

	@Test(priority = 7) // //Arranging items from Low to High and retrieving the last item
	public void SortPriceltoh() throws InterruptedException {
		Thread.sleep(2000);
		WebElement DropSort2 = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select Seloption2 = new Select(DropSort2);
		Seloption2.selectByVisibleText("Price (low to high)");
		String ExpectedlastName2 = "Sauce Labs Fleece Jacket";
		List<WebElement> Lastnampr2 = driver.findElements(By.className("inventory_item_name"));

		String Actuallastpr2 = Lastnampr2.get(Lastnampr2.size() - 1).getText();

		Assert.assertEquals(Actuallastpr2, ExpectedlastName2);

	}

	@Test(priority = 8) // //Arranging items from High to Low and retrieving the last item

	public void SortPricehtol() throws InterruptedException {

		Thread.sleep(2000);

		WebElement DropSort3 = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));

		Select Seloption3 = new Select(DropSort3);
		Seloption3.selectByVisibleText("Price (high to low)");

		String ExpectedlastName3 = "Sauce Labs Onesie";

		List<WebElement> Lastnampr3 = driver.findElements(By.className("inventory_item_name"));

		String Actuallastpr3 = Lastnampr3.get(Lastnampr3.size() - 1).getText();

		Assert.assertEquals(Actuallastpr3, ExpectedlastName3);

	}
}
