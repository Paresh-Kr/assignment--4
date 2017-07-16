package backupVisitors.myTree;

//import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
 
public class Node implements ObserverI,SubjectI{
	
	private int BNumber=-1;
	private String  Course=null;
	private Node left_child=null;
	private Node right_child=null;
	
	// private  ArrayList<Integer,String> list = new ArrayList<Integer,String>();
	 Map<ObserverI,Integer> linkedHashMap = new LinkedHashMap<ObserverI,Integer>();

	
	public  Node(int Bnum,String Course)
	{
		this.BNumber= Bnum;
		this.left_child=null;
		this.right_child=null;
		this.Course=Course;
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
	
	// add node as listener
	public void ListenerNode(ObserverI node,int Bnum ) { 
		linkedHashMap.put(node, Bnum);

	}
	

	//updateall

	@Override
	public void updateValue(int Bval,String Course) {
		// TODO Auto-generated method stub
		this.setBNumber(Bval);
		this.setCourse(Course);
	}

	@Override
	public void notifyAll(int updatevalue, String Course_no) {
		// TODO Auto-generated method stub
		 Map<ObserverI,Integer> Lmap = new LinkedHashMap<ObserverI,Integer>(linkedHashMap);
		 for(Entry<ObserverI, Integer> key :Lmap.entrySet())
		 {
			if(key.getValue().compareTo(updatevalue)==0) 
			{
				key.getKey().updateValue(updatevalue, Course_no);
			}
		 }

		
	}
}
