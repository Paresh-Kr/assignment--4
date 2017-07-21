package backupVisitors.visitor;

import java.util.ArrayList;
import java.util.Collections;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;

public class StatsVisitorImpl implements TreeVisitorI
{
	int sum=0;
	int Counter=0;
	float average;
	double median;
	ArrayList<Integer> CourseCountlist = new ArrayList<Integer>();

	
	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		findSum(Btree,nd);
		findCourselist(Btree,nd);
		
		  average =sum/Counter;
		  median= Findmedian();
		  //write to file
		
	}
	
	public void findSum(BinarySearchTree b,Node node)
	{
		if(node != null)
		{
			int k =node.getBNumber();
			sum=sum +node.getCourseList(k).size();
			Counter++;

	
			findSum(b,node.getLeftChild());
			findSum(b,node.getRightChild());

		}
		
		System.out.println(" Course Count---"+sum);
		
		
	}
	
	public void findCourselist(BinarySearchTree b,Node node)
	{
		if(node != null)
		{
			int CourseSize=0;
			int k =node.getBNumber();
			CourseSize=node.getCourseList(k).size();
			CourseCountlist.add(CourseSize);
			
			findSum(b,node.getLeftChild());
			findSum(b,node.getRightChild());

		}
		
		System.out.println(" Course Count-- "+sum) ;
		
		
	}
	
	public double Findmedian()
	{
	
	    Collections.sort(CourseCountlist);
	    
	    double middle = CourseCountlist.size()/2;
        if (CourseCountlist.size()%2 == 1) {
        	middle = (CourseCountlist.get(CourseCountlist.size()/2) + CourseCountlist.get(CourseCountlist.size()/2 - 1))/2;
        } else
        {

        }
      return middle;

	}
	
    }