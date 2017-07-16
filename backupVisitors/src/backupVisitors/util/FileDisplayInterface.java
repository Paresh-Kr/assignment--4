package backupVisitors.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public interface FileDisplayInterface 
{

public static void writeToFile(String s,int val)
{
	if(val==0){
		try(    FileWriter fw = new FileWriter("ouput1.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(s);
			} catch (IOException e) {
				System.out.println("Exception Happened in file File write");
			}
	}
	// output1
		else if(val==1){
			try(FileWriter fw = new FileWriter("ouput2.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(s);
				} catch (IOException e) {
					System.out.println("Exception Happened in file File write");
				}
		}
	//output2
	if(val==2){
		try(FileWriter fw = new FileWriter("ouput3.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(s);
			} catch (IOException e) {
				System.out.println("Exception Happened in file File write");
			}
		}
}
}
