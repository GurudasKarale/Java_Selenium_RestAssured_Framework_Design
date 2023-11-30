# Framework Design fundamentals

# Cucumber - selenium  

  1) POM design pattern is used to separate the locators from test steps.  
2) Class stepDef contains all the test step definitions for the scenarios maintained in feature file.  
3) Class KeywordsD contains the methods which interact with the UI/contains page specific code which are used by the test steps defined in the stepDef class.  
4) Locators are stored in properties file which are read by the methods defined in KeywordsD class to interact with the UI.  
5) Test data is stored in excel file along with the test case name which is read by method defined in ReadExcel utility class and returns the hashmap.  
6) As a part of validation , Jdbc utility class's method reads the data from postgres DB table and returns it for the validation against UI data.  
7) Test case failure is captured in test html report.  
 
# Selenium - TestNg  

  1) POM design pattern is used to separate the locators from code which interacts with the UI.  
2) Class TestDefinitions contains the testNg tests which uses the methods defined in classed stored in PageObjects package.  
3) Classes maintained in the PageObjects package contains the methods which interact with the UI/contains page specific code which are used by the testNg tests defined in the TestDefinitions class.  
4) Locators are stored in page object classes.  
5) BaseClass contains the methods to initialize the driver and open application url.  
6) As a part of validation , assertions are added in the tests.  
7) Test case failure/pass is captured in the extent report.  

# Cucumber - RestAssured  

  1) BDD(cucumber) approach is used to write and execute the rest api test scenarios and restassured is used to test/validate those scenarios.  
2) StepDefinitions class contains the methods defined for the test scenario steps maintained in the feature file.  
3) Utils class contains the methods to read the properties file and method to log the api request and response.  
4) TestDataRepository class in testData package contains the methods which returns the test data.  
5) Pojo classes are used for payload management , i.e with the help of Gson and jackson api the payload which needs to be sent as a request to the api is serialized.  
6) Reports - in progress  
