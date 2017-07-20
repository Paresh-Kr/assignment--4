package backupVisitors.visitor;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;

public class StatsVisitorImpl implements TreeVisitorI
{
	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		findfulltime(Btree,nd);
		
	}
	
	public void findfulltime(BinarySearchTree b,Node node)
	{
		if(node != null)
		{
			int k =node.getBNumber();
			if(node.getCourseList(k).size() <3)
			{
				b.updateTreenode(node,k,"S",1);
			}
		}
	}
}