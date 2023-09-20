@cart_feature
Feature: Cart
  @add_to_cart
  Scenario: adding_multiple_recommended_products_to_cart # 1
    Given user adds recommended products to cart
    When user navigates to cart
    Then user verifies cart is opened
   @increase_quantity
  Scenario: incrementing_number_of_product_with_lowest_price_by_one # 2
    Given user adds recommended products to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user increments quantity of the product with the lowest price by one and verifies
  @delete_product
  Scenario: delete_product_with_highest_price # 3
    Given user adds recommended products to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user deletes the product with the highest price by one and verifies
  @check_price
  Scenario: verifying_that_subtotal_and_total_prices_matching # 4
    Given user adds recommended products to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user verifies that subtotal and total prices are matching
  @update_shipping
  Scenario: update_shipping_destination # 5
    Given user adds recommended products to cart
    When user navigates to cart
    And user verifies cart is opened
    And user updates shipping destination
    Then user verifies that shipping destination was updated
  @proceed_checkout_negative
  Scenario: user_must_fulfill_minimum_cost_of_products_to_proceed_to_checkout # 6
    Given user adds recommended products to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user verifies that proceed button isn't clickable when the subtotal is less than 19
  @proceed_checkout_positive
  Scenario: user_can_proceed_to_checkout # 7
    Given user adds products that cost 19 or higher to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user verifies that proceed button is clickable when the subtotal is equal to or more than 19
  @delete_single_product
  Scenario: user_can_see_delete_icon_only_when_there_is_single_product # 8
    Given user adds a single product to cart
    When user navigates to cart
    And user verifies cart is opened
    Then user verifies that delete icon is visible
    And user increases the product quantity by one
    Then user verifies that delete icon is not visible anymore
  @readd_deleted_product
  Scenario: user_can_re-add_deleted_product_using_delete_alert # 9
    Given user adds a single product to cart
    When user navigates to cart
    And user verifies cart is opened
    And user clicks the delete icon to delete product
    And user click undo button to re-add product to the basket
    Then user verifies that product added to the basket
  @invalid_coupon
  Scenario: user_enters_invalid_coupon_and_gets_error_message # 10
    Given user adds a single product to cart
    When user navigates to cart
    And user verifies cart is opened
    And user clicks coupon field
    And user enters invalid coupon code
    Then user verifies that failure message is shown



