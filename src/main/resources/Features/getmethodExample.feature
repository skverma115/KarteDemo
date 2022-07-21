Feature: get Method Json Example
  @SmokeTest @SanityTest
  Scenario: Get Details using get method

Given url 'https://gorest.co.in/public/v2/posts/'
And path '100'
When method GET
Then status 200 
* print response 
* def temp = response
* print temp.id
* match temp.id == 100
