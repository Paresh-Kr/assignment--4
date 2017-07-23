package backupVisitors.driver;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.util.FileProcessor;
import backupVisitors.util.Results;
import backupVisitors.util.TreeBuilder;

public class Driver 
{

	public static void main(String[] args) 
	{
		System.out.println(" ----------Assignment-4 ------  ");
		FileProcessor fp = null;

		String Inputfile="";
		String Deletefile="";

		String Outputfile1="";
		String Outputfile2 ="";
		String Outputfile3 ="";
		//System.out.println("----argument---"+args.length);
		if(args.length <1)
		{
			System.out.println("Please provide Input file");
			System.exit(1);
		}else if(args.length >5)
		{
			System.out.println("Entered More than five file");
			System.exit(1);
		}else if( args.length==5 || args.length==5)
		{
			// fp= new FileProcessor(args[0],args[1]);
			// fp= new FileProcessor(args[0],args[1],args[2],args[3],args[4]);
			//System.out.println("--");

		
		Results rslt=new Results();

		Inputfile=args[0].toString();
		Deletefile=args[1].toString();
        Outputfile1= args[2].toString();
		Outputfile2 =args[3].toString();
		Outputfile3 =args[4].toString();
		BinarySearchTree Orig = new BinarySearchTree(); 
		BinarySearchTree backup1 = new BinarySearchTree();
		BinarySearchTree backup2 = new BinarySearchTree();
		TreeBuilder Builder = new TreeBuilder(rslt ,Orig, backup1,backup2,Inputfile,Deletefile,Outputfile1,Outputfile2,Outputfile3);
		Builder.readNode(); 
		

		  Builder.deletenode();
		  Orig.traversal(3);
		  System.out.println("\n::::----fulltimestatusvisitor------  ");

		 // Builder.fulltimestatusvisitor();
		  System.out.println("\n ::::---After fulltimestatusvisitor----Original tree--- \n");
			 Orig.traversal(3);
			System.out.println("\n ::::----identicalrecordsvisitor-----  ");

		     Builder.identicalrecordsvisitor();
			System.out.println("\n::::----startsvisitor----------  ");

		     Builder.startsvisitor();
			System.out.println("\n::::----sortedrecordvistor-----  ");

		     Builder.sortedrecordvistor();


		
		
		//System.out.println("\n ::::---After Delete.txt read-----Original tree--- \n");
		//Orig.traversal(0);
		
		//System.out.println(" \n::::---After Delete.txt read-----Backup_1 tree--- \n");

		//backup1.traversal(1);
		//System.out.println(" \n::::---After Delete.txt read-----Backup_2 tree--- \n");

		//backup2.traversal(2);
		
		//
		//
		}else{
			System.out.println("Please follow Instruction and give five input as argument ");
	
		}
	}
	
}
