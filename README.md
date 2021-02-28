# JHTestSample

Test package include positive and negative sample test cases along with two sets of test data in ”.xlsx “format.
In the test cases  you will find validation for each step.

Prerequisite:

_ Java JDK 1.7 or above
_ Maven installation (apache-maven-3.6.3-bin.zip )

	•	Following should be added to system environment Variables:
			 System variable Path -	C:\maven\bin
              		 System variable MAVEN_HOME   C:\maven


 _ Download the Test package to a Test folder 
 _ Source application should be up and running
 _ Using CMD command open Command Prompt Window
 _ Change directory to “Test folder” and type “mvn install” (first run may take longer due to installation process)
 _ Upon completion of the test “emailable-report.html” Report will be generated in .. \target\surefire
    directory. You can  access detailed individual test case result by clicking on hyperlink method column next to each test case.
