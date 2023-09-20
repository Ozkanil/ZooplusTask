Zooplus Cart Feature Automation Project 

This project hs been built to auotmate the cart feature of Zooplus. It includes 10 test cases that verifies that a user can add products to basket from the recommended products, delete the one with the highest price, increase the quantity of the one with the lowest price, change shipping destination, try adding an invalid coupon code, readd a product to the basket right after deletion, verify that total and subtotal prices are matching and proceed to the checkout.

This project was created in IntelliJ IDEA using Selenium, Cucumber framework and Gherkin language. Java is used as the binding language. The project was structured in line with the Page Object Model. 

In order to run the project, the user should add the tag of each scenario in "tags = {scenario tag} format and then run the RunnerTest class locally. The Hooks class will initialize the WebDriver and replace the cookies with the new one. The browser will automatically shut down at the end of the test. 
