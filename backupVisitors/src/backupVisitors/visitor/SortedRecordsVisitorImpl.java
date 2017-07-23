package backupVisitors.visitor;

import java.util.Collections;
import java.util.Enumeration;
import java.util.StringJoiner;

import backupVisitors.util.Results;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;

public class SortedRecordsVisitorImpl implements TreeVisitorI

{
	Results rslt=new Results();

	
	public void visit(BinarySearchTree Btree)
	{
		//implement

		Node nd= Btree.getroot();
		postorder(nd,1);
	}
	
	 public void postorder(Node node,int k)
     {
    	//
    	 if(node !=null)
    	 {
    		 

    		 postorder(node.getRightChild(),k);
    		 int key = node.getBNumber();
 			StringBuilder stringBuilder = new StringBuilder();
 			int l = node.getBNumber();
 			StringJoiner joiner = new StringJoiner(" :: ");
 			Enumeration<String> e = Collections.enumeration(node.getCourseList(l));
 			while (e.hasMoreElements()) {

 				stringBuilder.append(e.nextElement());
 			}

 			String finalString = stringBuilder.toString();

 			joiner.add(new Integer(node.getBNumber()).toString());

 			joiner.add(finalString.toString());
 			String joined = joiner.toString();
 			rslt.storeNewResult(joined, k);
            
    		    postorder(node.getLeftChild(),k);

    	 }
     }
}
