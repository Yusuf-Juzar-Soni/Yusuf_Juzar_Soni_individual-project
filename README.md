# Understanding Design Patterns
## Build an Inventory Management System incorporating Design Patterns
### Design Patterns Used
**Singleton Pattern**
Creational design Pattern that allows you to create a single instance of class. Provides single point of access to this instance. Helps the common code shared by different classes by preventing overriding of the data by various pieces of code that share the common data.
In our case, Since the mock database is being used by various other classes, it is advisable to create the MockDB using the singleton pattern. The default constructor is made private so that other classes cannot use the new operator on the MockDB class. Instead a static creation method is created that   acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.

![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Slide1.PNG)

**Factory Pattern**
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. The Factory pattern is usually used to extend the functionalities of a general type of class by providing subclasses that extend its parents functionalities in addition to adding specific behavior.
In our case, I have implemented the factory pattern to handle the result generation aspect of our project. I have created an abstract class ResultGenerator that contains abstract methods saveFile() and writeToFile(). This ResultGenerator is extended by the BillGenerator and ErrorGenerator classes. Both the abstract methods are overridden in the child class to implement their specific functionalities.

![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Slide2.PNG)


### Steps to run the Program.
* Java Version 11.0.8 Used
* Clone the project from GitHub using command:
 git clone https://github.com/Yusuf-Juzar-Soni/individual-project-Yusuf-Juzar-Soni.git
* Navigate to the src folder, and start cmd.
* Run Command:   javac MarketPlaceRunner.java
* Run Command:  java MarketPlaceRunner [Filepath of Dataset] **(Please enter the full path and do not include spaces in the Filename [See screenshots for reference]). I have added the dataset and 3 input files in the Files Folder in src. You can paste the remaining 2 files in the same folder and then specify path**
* The cmd screen will prompt yot to add the [Order Filepath]. Kindly enter the entire filepath. (See screenshots for reference.)
* Errorlog and FileOrderLog are generated in the src folder
  
### Screenshot
* Initial steps
![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Step1_2.PNG)
* Command Prompt Screen for the three input files
 ![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Screen_Capture_cmd.PNG)
* Log File for Input1
![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Input1.PNG)
* Log File for Input 2
 ![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Input2.PNG)
* Log File for Input 3 
![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Input3.PNG)

### Class Diagram
![image](https://github.com/Yusuf-Juzar-Soni/Yusuf_Juzar_Soni_individual-project/blob/main/Output%20Images/Class_Diagram.png)


