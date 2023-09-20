package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddToCart;
import pages.InteractWithCart;
import utilities.Driver;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class AddToCartStepDefs {

    Driver driver = new Driver();
    AddToCart addToCart = new AddToCart();
    InteractWithCart interactWithChart = new InteractWithCart();
    TreeSet<Double> sortedPrices = new TreeSet<Double>();
    String productText1;
    String productText2;
    String productText3;

    @When("user adds recommended products to cart")
    public void userAddTwoRecommendedProductsToCart() throws MalformedURLException {

        addToCart.firstProduct.click();
        addToCart.productQuantityBox.sendKeys("1");
        Driver.clickWithJS(addToCart.addToCart);
        Driver.clickWithJS(addToCart.backToHomePage);
        addToCart.secondProduct.click();
        addToCart.productQuantityBox.sendKeys("1");
        Driver.clickWithJS(addToCart.addToCart);
        Driver.waitAndClick(addToCart.companyLogo);
        addToCart.thirdProduct.click();
        addToCart.productQuantityBox.sendKeys("1");
        Driver.clickWithJS(addToCart.addToCart);
    }

    @And("user navigates to cart")
    public void userNavigatesToCart() {

        addToCart.navigateToCart.click();
    }

    @Then("user verifies cart is opened")
    public void userVerifiesCartIsOpened() {

        String url = Driver.driver.getCurrentUrl();
        Assert.assertTrue("You aren't in the cart", url.contains("cart"));
    }

    @And("user increments quantity of the product with the lowest price by one and verifies")
    public void userIncrementsQuantityOfTheProductWithTheLowestPriceByOne() {

        productText1 = addToCart.firstProductInCart.getText();
        List<String> productTextSplitted1 = Arrays.asList(productText1.split("€"));
        double productOnePrice = Double.parseDouble((productTextSplitted1.get(productTextSplitted1.size() - 1)));

        productText2 = addToCart.secondProductInCart.getText();
        List<String> productTextSplitted2 = Arrays.asList(productText2.split("€"));
        double productTwoPrice = Double.parseDouble((productTextSplitted2.get(productTextSplitted2.size() - 1)));

        productText3 = addToCart.thirdProductInCart.getText();
        List<String> productTextSplitted3 = Arrays.asList(productText3.split("€"));
        double productThreePrice = Double.parseDouble((productTextSplitted3.get(productTextSplitted3.size() - 1)));

        sortedPrices.add(productOnePrice);
        sortedPrices.add(productTwoPrice);
        sortedPrices.add(productThreePrice);

        if (productText1.contains(sortedPrices.first().toString())) {

            interactWithChart.firstProductInChart.click();
        }
        if (productText2.contains(sortedPrices.first().toString())) {

            interactWithChart.secondProductInCart.click();
        }
        if (productText3.contains(sortedPrices.first().toString())) {

            interactWithChart.thirdProductInCart.click();
        }
    }

    @Then("user deletes the product with the highest price by one and verifies")
    public void userDeletesTheProductWithTheHighestPriceByOneAndVerifies() {

        productText1 = addToCart.firstProductInCart.getText();
        List<String> productTextSplitted1 = Arrays.asList(productText1.split("€"));
        double productOnePrice = Double.parseDouble((productTextSplitted1.get(productTextSplitted1.size() - 1)));

        productText2 = addToCart.secondProductInCart.getText();
        List<String> productTextSplitted2 = Arrays.asList(productText2.split("€"));
        double productTwoPrice = Double.parseDouble((productTextSplitted2.get(productTextSplitted2.size() - 1)));

        productText3 = addToCart.thirdProductInCart.getText();
        List<String> productTextSplitted3 = Arrays.asList(productText3.split("€"));
        double productThreePrice = Double.parseDouble((productTextSplitted3.get(productTextSplitted3.size() - 1)));

        sortedPrices.add(productOnePrice);
        sortedPrices.add(productTwoPrice);
        sortedPrices.add(productThreePrice);

        if (productText1.contains(sortedPrices.last().toString())) {
            interactWithChart.deleteFirstProductInCart.click();

            Assert.assertFalse("Product wasn't deleted", addToCart.firstProductInCart.isDisplayed());
        }
        if (productText2.contains(sortedPrices.last().toString())) {
            interactWithChart.deleteSecondProductInCart.click();

            Assert.assertFalse("Product wasn't deleted", addToCart.secondProductInCart.isDisplayed());
        }
        if (productText3.contains(sortedPrices.last().toString())) {
            interactWithChart.deleteThirdProductInCart.click();

            Assert.assertFalse("Product wasn't deleted", addToCart.thirdProductInCart.isDisplayed());
        }
    }

    @Then("user verifies that subtotal and total prices are matching")
    public void userVerifiesThatSubtotalAndTotalPricesAreMatching() {

        double subtotal = Double.parseDouble(interactWithChart.subtotal.getText().substring(1));
        double shippingCost = Double.parseDouble(interactWithChart.shippingCost.getText().substring(1));
        double total = Double.parseDouble(interactWithChart.total.getText().substring(1));
        double expectedSubtotal = total - shippingCost;
        Assert.assertEquals("Expected and actual subtotals aren't equal", subtotal, expectedSubtotal, 0.0);
        System.out.println(subtotal);
        System.out.println(total);
    }

    @And("user updates shipping destination")
    public void userUpdatesShippingDestination() {

        interactWithChart.deliveryDropdown.click();
        interactWithChart.deliveryDropdownList.click();
        Driver.clickWithJS(interactWithChart.portugal);
        interactWithChart.postCodeBox.sendKeys("500");
        interactWithChart.updateButton.click();
    }

    @Then("user verifies that shipping destination was updated")
    public void userVerifiesThatShippingDestinationWasUpdated() {

        Assert.assertTrue("Shipping destination isn't Portugal", interactWithChart.deliveryDropdown.getText().contains("Portugal"));
    }

    @Then("user verifies that proceed button isn't clickable when the subtotal is less than {int}")
    public void userVerifiesThatProceedButtonIsnTClickableWhenTheSubtotalIsLessThen(int arg0) {

        double subtotal = Double.parseDouble(interactWithChart.subtotal.getText().substring(1));

        if (subtotal < 19) {
            Assert.assertFalse("Checkout button is enabled while it shouldn't", interactWithChart.checkoutButton.isEnabled());
        }
    }

    @When("user adds products that cost {int} or higher to cart")
    public void userAddsProductsThatCostOrHigherToCart(int totalProductCost) {

        addToCart.firstProduct.click();
        addToCart.productQuantityBox.sendKeys("10");
        Driver.clickWithJS(addToCart.addToCart);
    }

    @Then("user verifies that proceed button is clickable when the subtotal is equal to or more than {int}")
    public void userVerifiesThatProceedButtonIsClickableWhenTheSubtotalIsEqualToOrMoreThan(int totalProductCost) {

        double subtotal = Double.parseDouble(interactWithChart.subtotal.getText().substring(1));

        if (subtotal >= totalProductCost) {
            Assert.assertTrue("Checkout button is disabled while it shouldn't", interactWithChart.checkoutButton.isEnabled());
        }
    }

    @Given("user adds a single product to cart")
    public void userAddsASingleProductToCart() {

        addToCart.firstProduct.click();
        addToCart.productQuantityBox.sendKeys("1");
        Driver.clickWithJS(addToCart.addToCart);
    }

    @Then("user verifies that delete icon is visible")
    public void userVerifiesThatDeleteIconIsVisible() {

        Assert.assertTrue("Delete icon isn't visible", interactWithChart.deleteFirstProductInCart.isDisplayed());
    }

    @And("user increases the product quantity by one")
    public void userIncreasesTheProductQuantityByOne() {

        interactWithChart.firstProductInChart.click();
    }

    @Then("user verifies that delete icon is not visible anymore")
    public void userVerifiesThatDeleteIconIsNotVisibleAnymore() {

        Assert.assertTrue(interactWithChart.deleteFirstProductInCart.isDisplayed());
    }

    @And("user clicks the delete icon to delete product")
    public void userClicksTheDeleteIconToDeleteProduct() {

        interactWithChart.deleteFirstProductInCart.click();
    }

    @And("user click undo button to re-add product to the basket")
    public void userClickUndoButtonToReAddProductToTheBasket() throws InterruptedException {

        Thread.sleep(10000);

        Driver.waitForVisibility(interactWithChart.undoButton, 10).click();
    }

    @Then("user verifies that product added to the basket")
    public void userVerifiesThatProductAddedToTheBasket() {

        Assert.assertTrue("Product wasn't added to the basket", interactWithChart.firstProductInChart.isDisplayed());
    }

    @And("user clicks coupon field")
    public void userClicksCouponFiled() {

        interactWithChart.couponText.click();
    }

    @And("user enters invalid coupon code")
    public void userEntersInvalidCouponCode() {

        interactWithChart.couponBox.sendKeys("INVALID");
        interactWithChart.couponBoxButton.click();
    }

    @Then("user verifies that failure message is shown")
    public void userVerifiesThatFailureMessageIsShown() {

        String actualFailureMessage = interactWithChart.couponMessage.getText();
        String expectedFailureMessage = "The coupon code " + "INVALID" + " does not exist.";

        Assert.assertTrue("Failure message is not correct", actualFailureMessage.contains(expectedFailureMessage));

    }
}

