# Framework Design fundamentals

# Cucumber - selenium :  

  1) POM design pattern is used to separate the locators from test steps.  
2) Class stepDef contains a the test step definitions for the scenarios maintained in features file.  
3) Class KeywordsD contains the methods which interact with the UI/contains page specific code which are used by the test steps defined in the stepDef class.  
4) Locators are stored in properties file which are picked up by the methods defined in KeywordsD class to interact with the UI.  
5) Test data is stored in excel file along with the test case name which is read by method in ReadExcel and returns the hashmap.  
6) As a part of validation , Jdbc utility class method reads the data from postgres DB table and returns it for the validation against UI data.  
7) Test case failure is captured in test html report.  
 
