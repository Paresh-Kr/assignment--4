package backupVisitors.myTree;

import backupVisitors.util.Results;
import backupVisitors.visitor.TreeVisitorI;

import java.util.Collections;
import java.util.Enumeration;
import java.util.StringJoiner;

public class BinarySearchTree {
	Results rslt = new Results();
	private Node root;
	Node currentNode;
	Node pNode;

	public BinarySearchTree() {
		root = null;
	}

	public Node getroot() {
		return this.root;
	}

	public void insert(Node node) {
		// insert a node
		if (root == null) {
			root = node;

			return;
		}

		currentNode = root;
		pNode = null;
		while (true) {
			// String str=null;

			pNode = currentNode;
			if (node.getBNumber() < currentNode.getBNumber()) {
				// System.out.println("--------left-------"+currentNode.getBNumber());
				currentNode = currentNode.getLeftChild();
				if (currentNode == null) {
					pNode.setLeftChild(node);
					return;
				}
			} else if (node.getBNumber() > currentNode.getBNumber()) {
				// System.out.println("--------right-------"+currentNode.getBNumber());
				currentNode = currentNode.getRightChild();
				if (currentNode == null) {

					pNode.setRightChild(node);

					return;
				}
			} else {
				try {
					int Bnumber = node.getBNumber();
					String Course = node.getCourse();
					if (currentNode.getCourseList(Bnumber) != null && !currentNode.getCourseList(Bnumber).isEmpty()
							&& Course != null) {
						//System.out.println(" Course & Bnumber " + currentNode.getBNumber() + "----" + Course);
						Enumeration<String> e = Collections.enumeration(currentNode.getCourseList(Bnumber));
						while (e.hasMoreElements()) {
							if (e.nextElement().equals(Course)) {
								//System.out.println("----first time -- Course Matched--" + currentNode.getBNumber()+ "----" + Course);
								return;

							} else {
								//System.out.println("----Course Matched-- Update courselist----" + Bnumber + "----" + Course);
								// update tree with null as Course
								updateTreenode(currentNode, Bnumber, Course, 1);
								return;
							}
						}
						return;
					} else {

						//System.out.println("------xxxxxxxxx-----" + currentNode.getBNumber() + "----" + Course);
						updateTreenode(currentNode, Bnumber, Course, 1);
						return;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// delete Course from node
	public void delete(Node node, int Bnumber, String Course) {

		if (root == null) {
			root = node;

			return;
		}
		currentNode = root;
		pNode = null;
		while (true) {
			pNode = currentNode;
			if (Bnumber < currentNode.getBNumber()) {
				//System.out.println("--------left-------" + currentNode.getLeftChild().getBNumber());
				currentNode = currentNode.getLeftChild();
				if (currentNode == null) {
					return;
				}

			} else if (Bnumber > currentNode.getBNumber()) {
				//System.out.println("--------right-------" + currentNode.getRightChild().getBNumber());
				currentNode = currentNode.getRightChild();
				if (currentNode == null) {
					return;
				}
			} else {
				//System.out.println("Bvalue matched--" + currentNode.getBNumber() + "Actual Course "+ currentNode.getCourse() + "----delete course value--" + Course);
				try {
					if (currentNode.getCourseList(Bnumber) != null && !currentNode.getCourseList(Bnumber).isEmpty()
							&& Course != null) {

						//System.out.println("----updateTreenode----");
						// update tree with null as Course
						Enumeration<String> e = Collections.enumeration(currentNode.getCourseList(Bnumber));
						while (e.hasMoreElements()) {
							if (e.nextElement().equals(Course)) {
								//System.out.println("----Course Matched to delete ----"+Course +"--Courselist"+currentNode.getCourseList(Bnumber));

								updateTreenode(currentNode,Bnumber , Course, 0);
								return;

							}else
							{
								return;
							}
						}
					}else
					{
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	// update binary tree with duplicate Bnumber
	public void updateTreenode(Node node, int ival, String course, int flag) {
		int val = flag;
		if (node != null & course != null) {
			node.updateValue(ival, course, val);
		    node.notifyAll(ival,course);
		}

	}

	public void accept(TreeVisitorI vi) {
		vi.visit(this);
	}

	public void traversal(int treenum) {
		inorder(root, treenum);

	}

	public void inorder(Node node, int k) {
		//
		if (node != null) {
			inorder(node.getLeftChild(), k);
			int key = node.getBNumber();
			StringBuilder stringBuilder = new StringBuilder();
			int l = node.getBNumber();
			StringJoiner joiner = new StringJoiner(" - ");
			Enumeration<String> e = Collections.enumeration(node.getCourseList(l));
			while (e.hasMoreElements()) {

				stringBuilder.append(e.nextElement());
			}

			String finalString = stringBuilder.toString();

			joiner.add(new Integer(node.getBNumber()).toString());

			joiner.add(finalString.toString());
			String joined = joiner.toString();
		    rslt.storeNewResult(joined, 5);
			inorder(node.getRightChild(), k);

		}
	}

}
