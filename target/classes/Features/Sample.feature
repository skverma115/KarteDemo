Feature: print hello world features
	@SmokeTest
Scenario: Hello World Scenario 

* print 'Hello World' 
* print 'Hello Sumit Kumar Verma'

	@SanityTest
Scenario: Declare and print variable
	
	* def balance = 20
	* def sum = 300
	* def tax = 250
	
	* print 'Total Balance: ' + (balance+sum+tax)