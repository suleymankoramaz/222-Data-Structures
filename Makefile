compile:
	javac AList/*.java  
	javac LList/*.java
	javac LDLList/*.java

compileA:
	javac AList/*.java
compileL:
	javac LList/*.java
compileLD:
	javac LDLList/*.java

testall:
	java AList.TestClass1 > output_for_AList_test1.txt
	java AList.TestClass2 > output_for_AList_test2.txt
	java AList.TestClass3 > output_for_AList_test3.txt
	java AList.TestClass4 > output_for_AList_test4.txt
	java LList.TestClass1 > output_for_LList_test1.txt
	java LList.TestClass2 > output_for_LList_test2.txt
	java LList.TestClass3 > output_for_LList_test3.txt
	java LList.TestClass4 > output_for_LList_test4.txt
	java LDLList.TestClass1 > output_for_LDLList_test1.txt
	java LDLList.TestClass2 > output_for_LDLList_test2.txt
	java LDLList.TestClass3 > output_for_LDLList_test3.txt
	java LDLList.TestClass4 > output_for_LDLList_test4.txt

Atest1:
	java AList.TestClass1 > output_for_AList_test1.txt

Atest2:
	java AList.TestClass2 > output_for_AList_test2.txt

Atest3:
	java AList.TestClass3 > output_for_AList_test3.txt

Atest4:
	java AList.TestClass4 > output_for_AList_test4.txt


Ltest1:
	java LList.TestClass1 > output_for_LList_test1.txt

Ltest2:
	java LList.TestClass2 > output_for_LList_test2.txt

Ltest3:
	java LList.TestClass3 > output_for_LList_test3.txt

Ltest4:
	java LList.TestClass4 > output_for_LList_test4.txt

LDtest1:
	java LDLList.TestClass1 > output_for_LDLList_test1.txt

LDtest2:
	java LDLList.TestClass2 > output_for_LDLList_test2.txt

LDtest3:
	java LDLList.TestClass3 > output_for_LDLList_test3.txt

LDtest4:
	java LDLList.TestClass4 > output_for_LDLList_test4.txt

clean:
	rm AList/*.class
	rm LList/*.class
	rm LDLList/*.class

cleantxt:
	rm *.txt