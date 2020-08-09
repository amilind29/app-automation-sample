Feature: Online Shopping

Scenario: check cart price to the item price
	When I click on 'already a customer signin' button
	And I enter email as 'email@email.com'
	And I click continue button on email screen
	And I enter password as 'email@password'
	And I click on sign in button
	Then I should be on home screen 
	When I search for '65 inch TV' 
	And I select a result from suggestion
	Then I should see search result
	When I open random product
	Then I should see product details page
	When I add product to cart
	And I open cart
	Then I should see product in the cart
	And Price should match the product details page
	