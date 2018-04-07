all : BackEnd.class

BackEnd.class : BackEnd.java
	javac UserAccounts.java
	javac AvailableItems.java
	javac -cp . BackEnd.java
	javac -cp .:/usr/share/java/junit.jar AvailableItemsTest.java	
	javac -cp .:/usr/share/java/junit.jar UserAccountsTest.java
	javac -cp .:/usr/share/java/junit.jar BackEndTest.java


clean : 
	rm -f *.class
				
test :
	java -cp . BackEnd

compileTest :
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore AvailableItemsTest
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore UserAccountsTest
	java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore BackEndTest