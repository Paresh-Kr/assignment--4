package backupVisitors.util;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.util.FileProcessor;
import backupVisitors.myTree.*;

public class TreeBuilder {
	private FileProcessor fp=null;	
	private BinarySearchTree Node_orig=null,backup_Node_1=null,backup_Node_2=null;
	String Inputfile="";
	String Deletefile="";

	String Outputfile1="";
	String Outputfile2 ="";
	String Outputfile3 ="";
	
	public TreeBuilder(Results rslt,BinarySearchTree bst, BinarySearchTree bnode_1, BinarySearchTree bnode_2,String inputfile,String deletefile ,String outputfile1,String outputfile2,String outputfile3 ) {
		this.Node_orig= bst;
		this.backup_Node_1=bnode_1;
		this.backup_Node_2=bnode_2;
		//this.fp=fp;
		Inputfile=inputfile;
		Deletefile=deletefile;
		Outputfile1=outputfile1;
		Outputfile2=outputfile2;
		Outputfile3=outputfile3;
	}
	
	public void readNode(){
		 
		fp = new FileProcessor(Inputfile, Deletefile,Outputfile1,Outputfile2,Outputfile3); 

		

		
		String str;
		while ((str = fp.readLine()) != null)
		{ 
			int bnumber=0;
			String s = str;
			String delims = ":"; 
			String[] tokens = s.split(delims);
			String Course=null;
			try{
				bnumber = Integer.parseInt(tokens[0]);
				//System.out.println("-ReadNode---------Bnumber-----"+bnumber +"---string value---"+tokens[1]);
				Course =tokens[1].toString();
			}catch(NumberFormatException e){
				e.printStackTrace();
				System.exit(1);
			}
			
			Node Ori_node = new Node(bnumber,Course);
			Node Node_1 = new Node(bnumber,Course);
			Node Node_2 = new Node(bnumber ,Course);
			
			Ori_node.ListenerNode(Node_1,bnumber);
			Ori_node.ListenerNode(Node_2,bnumber);
			
			Node_orig.insert(Ori_node);
			backup_Node_1.insert(Node_1);
			backup_Node_2.insert(Node_2);
		}
	}
	// for Deleting Course
	public void deletenode()
	{
		fp = new FileProcessor(Inputfile, Deletefile,Outputfile1,Outputfile2,Outputfile3); 
		String str;
		while ((str = fp.readLined()) != null)
		{
		  int bnumber=0;
		  String s = str;
			String delims = ":"; 
			String[] tokens = s.split(delims);
			String Course=null;
			try{
				bnumber = Integer.parseInt(tokens[0]);
				//System.out.println("-delete---------number-----"+ bnumber +"---string value---"+tokens[1]);
				Course =tokens[1].toString();
				Node_orig.delete(Node_orig.getroot(),bnumber, Course);
			}catch(NumberFormatException e){
				e.printStackTrace();
				System.exit(1);
			}
			
			//Node_orig.delete( Node_orig.getroot(),bnumber, Course);
			backup_Node_1.delete( Node_orig.getroot(),bnumber, Course);
			backup_Node_2.delete( Node_orig.getroot(),bnumber, Course);
			
		}
		
 	
	}
	
}
