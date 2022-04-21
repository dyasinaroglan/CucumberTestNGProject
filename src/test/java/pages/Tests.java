package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Conditions;

import javax.annotation.meta.TypeQualifierNickname;
import static pages.Locators.*;
import static utils.WElement.open;
import static utils.WElement.$;


public class Tests {

    @Test
    public void test(){
        open(url);
        $(lsignIn).shouldBe(Conditions.CLİCKABLE).click();
        $(lCreateAnAccountText).shouldBe(Conditions.VİSİBLE);
        $(lemail).shouldBe(Conditions.VİSİBLE).sendKy("testngkurs@gmail.com");
        $(lpassword).shouldBe(Conditions.VİSİBLE).sendKy("testngkurs");
        $(lLogin).shouldBe(Conditions.CLİCKABLE).click();
        $(errorMessage).shouldBe(Conditions.APPEAR);

    }
}
