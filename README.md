
Realtor Website Test Case Automation Repository:

This Repository contains automation code to verify the listings price displayed. Understanding of Java, Selenium, and TestNG is required. The structure of the automation frameowork is cleary defined.

 1. All the test classes will be written in src/main/java/com/realtor/tests
  - The test we have is "ListingDetailsTestPlan" whose objective is to test if the listing price displayed is same on search results page and the listing details page
  
  Here's the flow:
  
  - launch realtor.com
  - click on the search bar and type in the location and submit the query
  - On the search results page, make sure there are N number of relavent listings and greater than zero
  - Once asserted, check the price listed for the 2nd listing and save it for assertion
  - Now, click on the listing so the listing details page opens
  - Assert the price shown here with the previously saved price
  
  The test plan follows the same flow as defined above.
  
2. All the locator and elements that define the UI pages will go as separate classes in src/main/com/realtor/pages

3. Any specifc action/method (such as logging into an account) will be written as a method in src/main/com/realtor/actions

4. Any project related resources will be present in src/main/resources/com/realtor

5. To run the test, we need to open the testNG.xml that is present in src/main/resources/com/realtor/testNG and run it through testNG. The order in which the test are executed is as follows:

Run the TestNG.xml(the test class path is mentioned in the file) ==> it will then start running any tests present in the class 
_______________________________________________________________

Any further developments in this repository need to follow the same structure by keeping all the UI page locators, Methods/flows/actions, testNG files, resources in their respectives folders. 
 
