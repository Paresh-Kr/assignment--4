package backupVisitors.util;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileProcessor {
	
	 private static int  Line_no=1;
	 private static int  Line_no_d=1;

	String Inputfile="";
	String Deletefile="";

	String Outputfile1="";
	String Outputfile2 ="";
	String Outputfile3 ="";

	public FileProcessor(String inputfile,String deletefile ,String outputfile1,String outputfile2,String outputfile3 )
	{
		Inputfile=inputfile;
		Deletefile=deletefile;
		Outputfile1=outputfile1;
		Outputfile2=outputfile2;
		Outputfile3=outputfile3;

		
	}

	private static BufferedReader br;

	public String readLine(){ //return one line at a time
		
	    String str="";
	    int Count = 1;
		try{
	    File file =new File(Inputfile);
	    if(!file.exists()){
	    	System.out.println("Please provide Input file");
	    	}
		
	    FileReader fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        while((str=br.readLine()) !=null) 
        {  
          if(Line_no ==Count)	
          {
          	Line_no=Count+1;
        	return str; // change for each line
          }
      	Count++;
        } 
        fileReader.close();
        br.close();
		}catch(IOException ie)
		{
			ie.printStackTrace();
			System.exit(1);
		}
	    
		return null;
		
	}
public String readLined(){ // reading from deletefile
		
	    String str="";
	    int Count = 1;
		try{
	    File file =new File(Deletefile);
	    if(!file.exists()){
	    	System.out.println("Please provide Input file");
	    	}
		
	    FileReader fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        while((str=br.readLine()) !=null) 
        {  
          if(Line_no_d == Count)	
          {
        	  Line_no_d=Count+1;
        	//System.out.println("-----readLined---"+str);
        	return str; // change for each line
          }
      	Count++;

        } 
        fileReader.close();
        br.close();
		}catch(IOException ie)
		{
			ie.printStackTrace();
			System.exit(1);
		}
	    
		return null;
		
	}
}

