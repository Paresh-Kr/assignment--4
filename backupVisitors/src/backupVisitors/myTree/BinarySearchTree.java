package backupVisitors.myTree;

import backupVisitors.util.Results;
import java.util.StringJoiner;


public class BinarySearchTree {
	Results rslt=new Results();
	private Node root;
	        Node currentNode;
            Node pNode;
	

	public BinarySearchTree(){
            root = null;
            }
	
	public Node getroot()
	{
       return  this.root;
	}
	public void insert(Node node){
	// insert a node
		if(root==null){
			root=node;
			return;
		}
		
		
		currentNode = root;
		pNode = null;
		while(true){
			//String str=null;
			pNode= currentNode;
			if(node.getBNumber()< currentNode.getBNumber()){
				//System.out.println("-------left node--------"+currentNode.getLeftChild());
				currentNode=currentNode.getLeftChild();
				if(currentNode ==null){
					pNode.setLeftChild(node);
					return;
				}
			}else if(node.getBNumber()> currentNode.getBNumber()){  
				//System.out.println("--------right-------"+currentNode.getRightChild());

				     currentNode=currentNode.getRightChild();    
					if(currentNode == null){

						pNode.setRightChild(node);
						
						return;
					}
			}else
			{
				//update tree for duplicate entry
				updateTreenode(currentNode,currentNode.getBNumber(),currentNode.getCourse());
				return;
			}
		}
	}
	
	// delete Course from node
	public void delete(Node node,int Bnumber,String Course){
		
		currentNode = root;
		pNode = null;
		while(true){
			pNode= currentNode;
			if(Bnumber< currentNode.getBNumber())
			{
				currentNode=currentNode.getLeftChild();
				if(currentNode ==null){
				 return ;
				}
				
			}else if(Bnumber > currentNode.getBNumber())
			{  
                   currentNode=currentNode.getRightChild();   
                   if(currentNode ==null){
      				 return ;
      				}
			}else
			{
				//System.out.println("Bvalue matched--"+currentNode.getBNumber()+ "Actual Course "+currentNode.getCourse()+"----delete course value--"+Course);
				try{
					if(currentNode.getCourse() !=null & Course !=null){
				if(currentNode.getCourse().equals(Course))
				{
				 // System.out.println("delete course matched");
				//update tree with null as Course
				updateTreenode(currentNode,currentNode.getBNumber(),null);
				}
			}
				return;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//update binary tree with duplicate Bnumber
		public void updateTreenode (Node node,int ival,String course){
			
			if(node!=null)
			{
				node.updateValue(ival,course); 
				node.notifyAll(ival,course);
			}

		}

     public void traversal(int treenum)
     {
    	 inorder(root,treenum);
    	 
     }
     public void inorder(Node node, int k)
     {
    	//
    	 if(node !=null)
    	 {
    		 inorder(node.getLeftChild(),k);
    		    if(k==0)
    		    {
    		    	StringJoiner joiner = new StringJoiner(":");
    		    	joiner.add(new Integer(node.getBNumber()).toString());
    		    	joiner.add(node.getCourse());
    		    	String joined = joiner.toString(); 
    		    	rslt.storeNewResult(joined,k);
    		    }else if(k==1)
    		    {StringJoiner joiner = new StringJoiner(":");
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
    		   inorder(node.getRightChild(),k);
    		 
    	 }
     }
	
}


