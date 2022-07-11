Feature: Create user using post call API

Background: 
* url 'https://gorest.co.in'
* def randon_string =
"""
function (s)
{
	var text = "";
	var pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	for(var i=0; i<s; i++)
		text += pattern.charAt(Math.floor(Math.random() * pattern.length()));
		return text;
}
	 
"""
* def randonString = randon_string(10)
* print randonString

* def requestpayload =
"""
{
"name": "sumit",
"gender": "male",
"status": "active"
}
"""
* requestpayload.email = randonString + "@gmail.com"
* print requestpayload.email
@SmokeTest
Scenario: Create user using given data 

#Step 1: Create User 

* def token = '4cf5a3adc501a506f811309e96c2fe51cb9eac17ff89a755441ed1913f162f87'
	Given path '/public/v1/users/'
	And request requestpayload
	And header authorization  = 'Bearer ' + token
	When method post
	Then status 201
	And match $.data.id == '#present'

#Step 2: Get user 

* def userID = $.data.id
* print userID

#Step 3: Delete user using userID

	Given path '/public/v1/users/' + userID
	And header authorization  = 'Bearer ' + token
	When method delete
	Then status 204
	
#Step 4: Get User 
	Given path '/public/v1/users/' + userID
	And header authorization  = 'Bearer ' + token
	When method GET
	Then status 404
	And match $.data.message == 'Resource not found'
