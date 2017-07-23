package backupVisitors.visitor;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;

public class FullTimeStatusVisitorImpl implements TreeVisitorI
{
	
	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		if(nd != null && Btree != null )
		{
		findfulltime(Btree,nd);
		}
	}
	
	public void findfulltime(BinarySearchTree b,Node node)
	{
		
		if(node != null)
		{
			int k =node.getBNumber();
			//System.out.println("The number of elements is : "+node.getCourseList(k));

			if(node.getCourseList(k).size() !=0){
			if(node.getCourseList(k).size() <3)
			{
				b.updateTreenode(node,k,"S",1);
			}
			}
			findfulltime(b,node.getLeftChild());
			findfulltime(b,node.getRightChild());

		}
	}
	
}
