Feature: get Method Json Example
  @SmokeTest @RegressionTest
  Scenario: Get Details using get method

* def query = {status : 'active' , gender : 'male' }
Given url 'https://gorest.co.in/public/v1/users/'
And params query
When method GET
Then status 200 
* print response 
* def temp = response
* print temp.id
* def count = temp.data.length
* print count