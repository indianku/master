package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HeaderClass;
import pomclasses.VerifyT_shirtModule;

public class TestClass
{
	public static WebDriver driver;
	HeaderClass headerClass;
	VerifyT_shirtModule verifyT_shirtModule;

	@BeforeMethod
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		headerClass = new HeaderClass(driver);
	}

	@Test
	public void test() throws InterruptedException 
	{
		Assert.assertEquals(headerClass.logoDisplay(), true);
		Assert.assertEquals(headerClass.womenTabEnable(), true);
		Assert.assertEquals(headerClass.dressesTabEnable(), true);
		Assert.assertEquals(headerClass.t_shirtTabEnable(), true);
		headerClass.selectT_Shirt();
		Thread.sleep(2000);
		verifyT_shirtModule = new VerifyT_shirtModule(driver);
		Assert.assertEquals(verifyT_shirtModule.checkTitle(), "T-SHIRTS ");
		verifyT_shirtModule.mouseHoverOnImage();
		verifyT_shirtModule.addToCart();
		System.out.println(verifyT_shirtModule.popupMessage());
		SoftAssert soft = new SoftAssert();
		// soft.assertEquals(verifyT_shirtModule.popupMessage(),"Product successfully
		// added to your shopping cart");
		// Assert.assertEquals(log.popupMessage(), "Product successfully added to your
		// shopping cart");
		Assert.assertEquals(verifyT_shirtModule.continueShopping(), true);
		Assert.assertEquals(verifyT_shirtModule.procedToCheckout(), true);
		verifyT_shirtModule.procedTo();
		System.out.println(verifyT_shirtModule.shoppingCartSummary());
		// soft.assertEquals(verifyT_shirtModule.shoppingCartSummary(), "SHOPPING-CART
		// SUMMARY ");
		soft.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
