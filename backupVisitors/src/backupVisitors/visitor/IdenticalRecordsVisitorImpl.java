package backupVisitors.visitor;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdenticalRecordsVisitorImpl implements TreeVisitorI
{

	private Map<Integer, List<Integer>> map = new HashMap <Integer, List<Integer>>();
	private Map<Integer, List<String>> Gcourse = new HashMap <Integer, List<String>>();

    int group_no=1;

	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		FindIdentical(Btree,nd,map,Gcourse);
		//write to file
		
	}
	
	public void FindIdentical(BinarySearchTree b,Node node,Map <Integer, List<Integer>> map,Map <Integer, List<String>> Gmap)
	{
		if(node != null)
		{
			int k =node.getBNumber();
			int Counter_1=0;
			int Counter_2=0;

			if(node == b.getroot())
			{
				addtoGroup(map,group_no,k);	
				Enumeration<String> e = Collections.enumeration(node.getCourseList(k));
			    while(e.hasMoreElements()){
				
				addtoGcourse(Gcourse,group_no,e.nextElement());
				
			    }
			} else
			{
		    Enumeration<String> e = Collections.enumeration(node.getCourseList(k));
		    while(e.hasMoreElements()){
		    	Counter_1++;
		    	for (Map.Entry<Integer, List<String>> entry : Gmap.entrySet()) {
		    		Integer key = entry.getKey();
		    	    List<String> value = entry.getValue();
		    	    for(String aString : value){
		    	        if(aString.equalsIgnoreCase(e.nextElement()))
		    	        {
		    	        	Counter_2++;	
		    	        }
		    	    	
		    	    	//System.out.println("key : " + key + " value : " + aString);
		    	    }
		    	}
		    	
		    }

			}
			if(Counter_1 ==Counter_2)
			{
				addtoGroup(map,group_no,k);
			}else
			{
				group_no++;
				addtoGroup(map,group_no,k);
				Enumeration<String> e = Collections.enumeration(node.getCourseList(k));
			    while(e.hasMoreElements()){
				
				addtoGcourse(Gcourse,group_no,e.nextElement());
				
			    }
			}
			
			FindIdentical(b,node.getLeftChild(),map,Gmap);
			FindIdentical(b,node.getRightChild(),map,Gmap);

		}
		
	}
	
	public void addtoGcourse(Map <Integer, List<String>> map, Integer key, String value){
		
		  if(!map.containsKey(key)){
		    map.put(key, new ArrayList<String>());
		  }
		  map.get(key).add(value);
		}
	
	
	public void addtoGroup(Map <Integer, List<Integer>> map, Integer key, Integer value){
		
		  if(!map.containsKey(key)){
		    map.put(key, new ArrayList<Integer>());
		  }
		  map.get(key).add(value);
		}
	
}