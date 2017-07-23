package backupVisitors.visitor;

import backupVisitors.myTree.BinarySearchTree;
import backupVisitors.myTree.Node;
import backupVisitors.util.Results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class IdenticalRecordsVisitorImpl implements TreeVisitorI
{

	private Map<Integer, List<Integer>> Group = new HashMap <Integer, List<Integer>>();
	private Map<Integer, List<String>> Gcourse = new HashMap <Integer, List<String>>();

    int group_no=1;
	Results rslt=new Results();


	public void visit(BinarySearchTree Btree)
	{
		//implement as per Full Time visitor
		Node nd= Btree.getroot();
		FindIdentical(Btree,nd,Group,Gcourse);
		//write to file
		Writetofile();
		
	}
	
	public void FindIdentical(BinarySearchTree b,Node node,Map <Integer, List<Integer>> map,Map <Integer, List<String>> Gmap)
	{
		if(node != null)
		{
			//int flag=0;
			int k =node.getBNumber();
			int Counter_1=0;
			int Counter_2=0;
			{
		    Enumeration<String> e = Collections.enumeration(node.getCourseList(k));
		    while(e.hasMoreElements()){
		    	String temp=e.nextElement();
		    	Counter_1++;
		    	for (Map.Entry<Integer, List<String>> entry : Gmap.entrySet()) {
		    		Integer key = entry.getKey();
		    	    List<String> value = entry.getValue();
		    	    for(String aString : value){
		    	        if(aString.equals(temp))
		    	        {
		    	        	Counter_2++;
		    	        	//System.out.println("temp : " + temp + " value : " + aString); 
		    	        	
		    	        }else{
		    	           //flag=0;
		    	        }
		    	    	
		    	    	
		    	        
		    	    }
		    	}
		    	
		    }
			}
			if(Counter_1 ==Counter_2)
			{
				addtoGroup(map,group_no,k);
				
			}else
			{
				
				addtoGroup(map,group_no,k);
				Enumeration<String> e = Collections.enumeration(node.getCourseList(k));
			    while(e.hasMoreElements()){
				
				addtoGcourse(Gmap,group_no,e.nextElement());
				
			    }
			    group_no++;
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
	public void Writetofile()
	{
		  for (Map.Entry<Integer, List<Integer>> entry : Group.entrySet()) {
	    		Integer key = entry.getKey();
	   		    String s = "Group";
	   		 StringBuilder stringBuilder = new StringBuilder();
	 		//StringBuilder grouplist = new StringBuilder();
            StringJoiner joiner = new StringJoiner(" - ");
            StringJoiner internal = new StringJoiner(" , ");

	     	   stringBuilder.append(s);


                stringBuilder.append(new Integer(key-1).toString());

	    	    List<Integer> value = entry.getValue();
    	    	System.out.println("key : " + (key-1) + " value : " + value);

	    	    for(Integer a : value){
	    	        
	    	    	//grouplist.append(a);
	    	    	internal.add(a.toString());
	    	    	//System.out.println("key : " + key + " value : " + a);
	    	    }
	    	    String finalString = stringBuilder.toString();
	       	    String finalgroup = internal.toString();
	    		joiner.add(finalString.toString());
	            joiner.add(finalgroup.toString());
	            String joined = joiner.toString(); 
	    	    rslt.storeNewResult(joined,2);
	    	}
	    
		
	}
	
}