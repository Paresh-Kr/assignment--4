
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 07/20/2017]
Paresh Kumar Giri
-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

All tree operation like insert,delete are done with O(log n) and other function like statsvistor,identical group,  are done with constant time O(nlogn) as i used Hasmap.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

 
Code :--
   1) for input argument check :  
       I checked for no of argument =5 ,<1 and >5 ,I assume that user will follow the input format.( as in assignment asked to take all 5 txt file as argument)
   2) when input file have same BNumber and with different course. I updated the Courselist with new value.
   4) Assumed except input.txt and delete.txt, all file must be empty.