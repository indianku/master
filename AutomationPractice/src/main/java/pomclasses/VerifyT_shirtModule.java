package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyT_shirtModule {
	private WebDriver driver;
	@FindBy(xpath="//span[@class='cat-name']")private WebElement tshirt;
	@FindBy(xpath="(//a[@class='product-name'])[2]")private WebElement lmg;
	@FindBy(xpath="//span[text()='Add to cart']")private WebElement addtoCart;
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")private WebElement sucessful;
	@FindBy(xpath="//span[@title='Continue shopping']")private WebElement continues;
	@FindBy(xpath="//a[@title='Proceed to checkout']")private WebElement proceed;
	@FindBy(xpath="//h1[@id='cart_title']")private WebElement summary;
	 public VerifyT_shirtModule(WebDriver driver)
	   {PageFactory.initElements(driver, this);
		  this.driver=driver;
	   }
	 
	  public String checkTitle()
	  {String g=tshirt.getText();
		return g;
	  }
	
	  public void mouseHoverOnImage() throws InterruptedException
	  { Actions act=new Actions(driver);
	      act.moveToElement(lmg).perform(); 
	      Thread.sleep(1000);
	      act.click().build().perform();
	  }
	  public void addToCart()
	  { addtoCart.click();
	  }
	  public String popupMessage()
	  {String pop= sucessful.getText();
		 return pop;
	  }
	  public boolean continueShopping()
	  { boolean cont=continues.isEnabled();
		  return cont;
	  }
	  public boolean procedToCheckout()
	  {boolean proces=proceed.isEnabled();
		  return proces;
	  }  
	  public void procedTo()
	  {proceed.click();  
	  }
	  public String shoppingCartSummary()
	  { String e= summary.getText();
		 return e;
	  }
}
