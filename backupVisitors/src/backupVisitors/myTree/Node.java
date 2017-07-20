package backupVisitors.myTree;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
public class Node implements ObserverI,SubjectI{
	
	private int BNumber=-1;
	private String  Course=null;
	private Node left_child=null;
	private Node right_child=null;
	
	private HashMap<Integer,ArrayList<String>>Data= new HashMap<Integer,ArrayList<String>>();
	private ArrayList<String>CourseList= new ArrayList<String>();
	
	// private  ArrayList<Integer,String> list = new ArrayList<Integer,String>();
	//Map<Integer,List<Integer>> Data = new Map<Integer,List<Integer>>();

	 Map<ObserverI,Integer> linkedHashMap = new LinkedHashMap<ObserverI,Integer>();

	
	public  Node(int Bnum,String Course)
	{
		super();
		this.BNumber= Bnum;
		this.left_child=null;
		this.right_child=null;
		this.Course=Course;
		//CourseList= new ArrayList<String>();
		//Data= new HashMap<Integer,ArrayList<String>>();
	}
	//getter setter for all value of node
	
	public Node getLeftChild() {
		return left_child;
	}

	public void setLeftChild(Node left) {
		this.left_child = left;
	}

	public Node getRightChild() {
		return right_child;
	}

	public void setRightChild(Node right) {
		this.right_child = right;
	}

	public int getBNumber() {
		return BNumber;
	}
	public void setBNumber(int Bnum) {
		BNumber = Bnum;
	}
	
	public String getCourse() {
		return Course;
	}
	public void setCourse(String BCourse) {
		Course = BCourse;
	}
	
	public HashMap<Integer,ArrayList<String>>getData()
	{
		return this.Data;
	}
	
	public void  setData( HashMap<Integer,ArrayList<String>>Data)
	{
		this.Data=Data;
	}
	
	public ArrayList<String>getCourseList(Integer i)
	{
		return Data.get(i);
	}
	
	public void  setCourseList(Integer i,ArrayList<String>Courselist)
	{
       this.Data.put(i, Courselist);
    }
	/*
	public ArrayList<String> getCourseList() {
	    return CourseList;
	}

	public void setCourseList(ArrayList<String> courseList)
	{
	    this.CourseList=courseList;
	}
	*/
	
	
	// add node as listener
	public void ListenerNode(ObserverI node,int Bnum ) { 
		linkedHashMap.put(node, Bnum);

	}
	

	//update all

	@Override
	public void updateValue(int Bval,String Course,int flag) {
		// TODO Auto-generated method stub
		String x= new String("");

		if(Course !=null){
          x=Course;
		if(flag == 1 && null != this.getCourseList(Bval) && !this.getCourseList(Bval).isEmpty()){
		this.setBNumber(Bval);
		/* have add all Course*/
		this.getCourseList(Bval).add(x);
		this.setCourseList(Bval, this.getCourseList(Bval));
		this.setCourse(x);
		}else if(flag == 0 )
		{
			this.setBNumber(Bval);
			/* have add all Course*/
			  if(this.getCourseList(Bval).isEmpty()){
			this.getCourseList(Bval).remove(x);
			this.setCourseList(Bval, this.getCourseList(Bval));
			this.setCourse(x);

			  }else
			  {
				  System.out.println("Course List is Empty, Can't be delete");
			  }
		}else
		{
			if( null != this.getCourseList(Bval) && !this.getCourseList(Bval).isEmpty()){
			this.setBNumber(Bval);
			/* have add all Course*/
			this.getCourseList(Bval).add(x);
			this.setCourseList(Bval, this.getCourseList(Bval));
			this.setCourse(x);
		}
		}
		
		}else
		{
			//do nothing
		}
	}

	@Override
	public void notifyAll(int updatevalue, String Course_no) {
		// TODO Auto-generated method stub
		 Map<ObserverI,Integer> Lmap = new LinkedHashMap<ObserverI,Integer>(linkedHashMap);
		 for(Entry<ObserverI, Integer> key :Lmap.entrySet())
		 {
			if(key.getValue().compareTo(updatevalue)==0) 
			{
				key.getKey().updateValue(updatevalue, Course_no,1);
			}
		 }

		
	}
}
