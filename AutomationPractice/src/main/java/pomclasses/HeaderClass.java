package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderClass {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath="//img[@class='logo img-responsive']") private WebElement logo;
	@FindBy(xpath="//a[text()='Women']") private WebElement women;
	@FindBy(xpath="(//a[text()='Dresses'])[2]")private WebElement dresses;
	@FindBy(xpath="(//a[text()='T-shirts'])[2]") private WebElement t_shirt;
	  public HeaderClass(WebDriver driver)
	   {PageFactory.initElements(driver, this);
		   this.driver=driver;
	   }
	  public boolean logoDisplay()
	  {boolean result=logo.isDisplayed();
		  return  result;
	  }
	  public boolean womenTabEnable()
	  {  boolean results=women.isEnabled();
	     return results;
	  }
	  public boolean dressesTabEnable()
	  {  boolean resul=dresses.isEnabled();
	     return resul;
	  }
	  public boolean t_shirtTabEnable()
	  {  boolean resultss=t_shirt.isEnabled();
	     return resultss;
	  }
	  public void selectT_Shirt()
	  {		   wait=new WebDriverWait(driver,40);
          wait.until(ExpectedConditions.visibilityOf(t_shirt));
		  t_shirt.click();
	  }
}
