CSCE 155A Vending Machines

Required imports:
import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;

Files:
1. readme.txt -> Contains descriptions for files related to the program
2. test.txt -> Contains the printed results of 2 program test trials
3. Item.java -> Source file that contains code that can be compiled and run in a Java IDE
4. VendingMachine.java -> Source file that contains code that can be compiled and run in a Java IDE
5. VendingMachineDriver.java -> Source file that contains code that can be compiled and run in a Java IDE

*NOTE: VendingMachineDriver.java calls 2 text files ("snacks.txt" and "drinks.txt"). These files must be
located within a folder titled "data" within the Java project in Eclipse. The format of thes files must
be as follows:
Description,Price,Quantity
e.g.
Milk,2.00,1
OJ,2.50,6