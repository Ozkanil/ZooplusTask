package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.AddToCart;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {

    @Before
    public void navigateToHomePage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("home_page_url"));

        AddToCart addToCart = new AddToCart();
        final WebDriver webDriver = Driver.getDriver();

        addToCart.cookieWindow.click();

        Cookie cookie = webDriver.manage().getCookieNamed("sid");
        webDriver.manage().deleteCookie(cookie);
        webDriver.manage().addCookie(
                new Cookie.Builder("newCookie", "ozkan-ilhan-test")
                        .domain(cookie.getDomain())
                        .expiresOn(cookie.getExpiry())
                        .path(cookie.getPath())
                        .isSecure(cookie.isSecure())
                        .build()
        );
    }
    @After
    public void CloseDriver(){

         Driver.closeDriver();
    }
}




