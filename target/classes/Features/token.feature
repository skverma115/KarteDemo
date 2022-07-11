Feature: get Method Json Example
	@RegressionTest
Scenario: Get Details using get method 
	
	* def token = '4cf5a3adc501a506f811309e96c2fe51cb9eac17ff89a755441ed1913f162f87'
	Given header authorization  = 'Bearer ' + token
	Given url 'https://gorest.co.in/public/v1/users/'
	And path '30' 
	When method GET
	Then status 200 
	* print response 
	* def temp = response
	* print temp.data.id