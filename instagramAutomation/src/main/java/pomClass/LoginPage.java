package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	@FindBy(xpath=" (//div[@class='EPjEi']//div)[14]")private WebElement loginas;
	@FindBy(xpath="//input[@id='email']")private WebElement user;
	@FindBy(xpath="//input[@id='pass']")private WebElement password;
	@FindBy(xpath="//button[@id='loginbutton']")private WebElement login;
	
	public LoginPage(WebDriver driver) {PageFactory.initElements(driver, this);}
	public void selectloginas() {loginas.click();}
	public void enterUser() {user.sendKeys("0000000000");}
	public void selectPassword() {password.sendKeys("abcdef");}
	public void selectlogin() {login.click();}
	
	
	
	
	
}
