package pages;

import org.openqa.selenium.By;

public interface Locators {

    String url = "http://automationpractice.com/index.php";
    By lsignIn = By.cssSelector("a[class='login']");
    By lCreateAnAccountText = By.xpath("(//h3[@class='page-subheading'])[1]");
    By lemail = By.xpath("(//input[@class='is_required validate account_input form-control'])[2]");
    By lpassword = By.xpath("(//input[@class='is_required validate account_input form-control'])[3]");
    By lLogin = By.cssSelector("i[class='icon-lock left']");
    By errorMessage = By.cssSelector("div[class='alert alert-danger'] ol");

}
