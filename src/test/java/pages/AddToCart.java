package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddToCart {

    public AddToCart(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement cookieWindow;
    @FindBy(xpath = "(//*[@class='z-anchor RecommendationProductCard_slideCard__Vevzs'])[2]")
    public WebElement firstProduct;
    @FindBy(xpath = "(//*[@class = 'z-anchor RecommendationProductCard_slideCard__Vevzs'])[3]")
    public WebElement secondProduct;
    @FindBy(xpath = "(//*[@class = 'z-anchor RecommendationProductCard_slideCard__Vevzs'])[4]")
    public WebElement thirdProduct;
    @FindBy(xpath = "(//*[contains(@title, 'Add to basket')])[1]")
    public WebElement addToCart;
    @FindBy(xpath = "//*[@class='cartButton-module_cartButton__lIc-O']")
    public WebElement navigateToCart;
    @FindBy(xpath = "(//*[@class = 'z-qty-stepper__input'])[1]")
    public WebElement productQuantityBox;
    @FindBy(xpath = "//*[@id = 'srh-logo']")
    public WebElement companyLogo;
    @FindBy(xpath = "(//*[@class = '_y8rnTfjeHCx2lXE5RDE'])[1]")
    public WebElement firstProductInCart;
    @FindBy(xpath = "(//*[@class = '_y8rnTfjeHCx2lXE5RDE'])[2]")
    public WebElement secondProductInCart;
    @FindBy(xpath = "(//*[@class = '_y8rnTfjeHCx2lXE5RDE'])[3]")
    public WebElement thirdProductInCart;
    @FindBy(xpath = "//*[contains (text(), 'back to category')]")
    public WebElement backToHomePage;









}
