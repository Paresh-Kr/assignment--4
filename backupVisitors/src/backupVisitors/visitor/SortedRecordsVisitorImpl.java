package backupVisitors.visitor;

import java.util.StringJoiner;

import backupVisitors.myTree.BinarySearchTree;
import src.backupVisitors.myTree.Node;

public class SortedRecordsVisitorImpl implements TreeVisitorI

{
	
	public void visit(BinarySearchTree Btree)
	{
		//implement
		Node nd= Btree.getroot();
		postorder(nd,2);
	}
	
	 public void postorder(Node node, int k)
     {
    	//
    	 if(node !=null)
    	 {
    		 postorder(node.getRightChild(),k);

    		    if(k==0)
    		    {
    		    	StringJoiner joiner = new StringJoiner(":");
    		    	joiner.add(new Integer(node.getBNumber()).toString());
    		    	joiner.add(node.getCourse());
    		    	String joined = joiner.toString(); 
    		    	rslt.storeNewResult(joined,k);
    		    }else if(k==1)
    		    {
    		    StringJoiner joiner = new StringJoiner(":");
		    	joiner.add(new Integer(node.getBNumber()).toString());
		    	joiner.add(node.getCourse());
		    	String joined = joiner.toString(); 
		    	rslt.storeNewResult(joined,k);
    		    }else if(k==2)
    		    {StringJoiner joiner = new StringJoiner(":");
		    	joiner.add(new Integer(node.getBNumber()).toString());
		    	joiner.add(node.getCourse());
		    	String joined = joiner.toString(); 
		    	rslt.storeNewResult(joined,k);
    		    }else if(k==3)
    		    {StringJoiner joiner = new StringJoiner(":");
		    	joiner.add(new Integer(node.getBNumber()).toString());
		    	joiner.add(node.getCourse());
		    	String joined = joiner.toString(); 
		    	rslt.storeNewResult(joined,k);
    		    }
    		    postorder(node.getLeftChild(),k);

    	 }
     }
}
