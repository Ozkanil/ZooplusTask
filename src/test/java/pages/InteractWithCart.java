package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InteractWithCart {

    public InteractWithCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[2]")
        public WebElement firstProductInChart;
        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[4]")
        public WebElement secondProductInCart;
        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[6]")
        public WebElement thirdProductInCart;

        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[1]")
        public WebElement deleteFirstProductInCart;
        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[3]")
        public WebElement deleteSecondProductInCart;
        @FindBy(xpath = "(//*[@class = 'z-qty-stepper__btn'])[5]")
        public WebElement deleteThirdProductInCart;

        @FindBy(xpath = "(//*[@class = 'z-p1'])[1]")
        public WebElement subtotal;
        @FindBy(xpath = "//*[@class='z-p1 oDjCMDgtYAFWzTJ_i7xo']")
        public WebElement shippingCost;
        @FindBy(xpath = "(//*[@class='z-h3'])[4]")
        public WebElement total;

        @FindBy(xpath = "//*[@class='z-anchor z-anchor--bold n2dkd1yIYnJYzN3peGzt']")
        public WebElement deliveryDropdown;
        @FindBy(xpath = "//*[@class='z-dropdown-menu__trigger']")
        public WebElement deliveryDropdownList;
        @FindBy(xpath = "//*[@class='z-text-input z-input']")
        public WebElement postCodeBox;
        @FindBy(xpath = " (//*[@class='z-p1'])[22]")
        public WebElement portugal;
        @FindBy(xpath = "//*[@class='z-btn z-btn--wide z-btn--primary l3eYVJPb3Dc_Rkt0baPa']")
        public WebElement updateButton;
        @FindBy(xpath = "//*[@class='z-btn z-btn--cart QZv8p1HLCmHYzKI4257x VAO7fB6beSPO2wyiIBHT']")
        public WebElement checkoutButton;
        @FindBy(xpath = "//*[@class = 'z-anchor z-anchor--bold']")
        public WebElement undoButton;
        @FindBy(xpath = "(//*[@class = 'z-anchor z-anchor--bold'])[2]")
        public WebElement couponText;
        @FindBy(xpath = "//*[@class = 'z-text-input z-input']")
        public WebElement couponBox;
        @FindBy(xpath = "//*[@class = 'z-p1 xwP3GtAgg3JJUqfZ2j6d']")
        public WebElement couponMessage;
        @FindBy(xpath = "//*[@class = 'z-btn z-btn--primary']")
        public WebElement couponBoxButton;































}