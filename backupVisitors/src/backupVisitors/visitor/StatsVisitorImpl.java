package backupVisitors.visitor;

import java.util.StringJoiner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.StringJoiner;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;
import backupVisitors.util.Results;

public class StatsVisitorImpl implements TreeVisitorI
{
	int sum=0;
	int Counter=0;
	double average;
	int mid;
	ArrayList<Integer> CourseCountlist = new ArrayList<Integer>();
	Results rslt=new Results();

	
	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		findCourselist(Btree,nd);
		findSum();
		Counter=CourseCountlist.size();
         if(Counter >0){
		  average = (double) sum/Counter;
         }
		  mid= Findmedian();
		  //write to file
		  
		  StringJoiner joiner = new StringJoiner("  ----  ");
		  String s = String.valueOf(average);

		  joiner.add(s.toString());
          joiner.add(new Integer(CourseCountlist.get(mid)).toString());
          String joined = joiner.toString(); 
	      rslt.storeNewResult(joined,0);

		
	}
	
	public void findSum()
	{
		if(!CourseCountlist.isEmpty())
		{
			Enumeration<Integer> e = Collections.enumeration(CourseCountlist);
			while (e.hasMoreElements()) {
                
				sum=sum+e.nextElement();
				//stringBuilder.append(e.nextElement());
			}

		}
		

		
	}
	
	public void findCourselist(BinarySearchTree b,Node node)
	{
		if(node != null)
		{
			int CourseSize=0;
			int k =node.getBNumber();
			CourseSize=node.getCourseList(k).size();
			CourseCountlist.add(CourseSize);
			
			findCourselist(b,node.getLeftChild());
			findCourselist(b,node.getRightChild());

		}		
		
	}
	
	public int Findmedian()
	{
	    int middle=0;
	    Collections.sort(CourseCountlist);
	   if(CourseCountlist.size() >=2) {
	     middle = CourseCountlist.size()/2;
        if (CourseCountlist.size()%2 == 1) {
        	middle = (CourseCountlist.get(CourseCountlist.size()/2) + CourseCountlist.get(CourseCountlist.size()/2 - 1))/2;
        } else
        {

        }
	   }
      return middle;

	}
	
    }