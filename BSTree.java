
/*Requirement 2: Add to the code in order to make it run. Specifically, your implementation must 
have the implementation of a class called BSTree.java.For the proper implementation of this class,
your implementation may require an additional class representing a node in the tree.

This class must have the functions discussed in the Background section: insert, find and delete. 
In addition, your implementation must have two additional functions which return the data in the BST:
+ String toStringInOrder(): returns a space-separated copy of the contents stored in the BST in (sorted) order.
+ String toStringPreOrder(): returns a space-separated copy of the contents stored in 
	the BST in pre-order: the contents of the root node, followed by the contents of the left child 
	and the contents of the right child.

When the implementation is correct, the output will indicate a starting point for the implementation grade.


Needs: insert
		find
		delete
		toStringInOrder()
		toStringPreOrder()
 */

public class BSTree {

	private Node root;

	//Excess constructors
	/*public BSTree()
	{
		root = new Node();
	}

	public BSTree(String data)
	{
		root = new Node(data);
	}*/

	public void insert(String insertedString)
	{
		root = insert(insertedString, root);
		//Excessive checks:
		/*Node newNode = new Node(insertedString);
		if(root.getData() == null)
		{
			root = newNode;
		}
		else
		{
			insert(insertedString, root);
		*/
	}
	private Node insert(String insertedString, Node node)
	{
		//if tree is not empty and we are on an empty leaf
		if(node == null)
		{
			return new Node(insertedString);
		}
		//Inserting left, else right
		if(insertedString.compareTo(node.getData()) < 0)
		{
			node.setLeft( insert(insertedString, node.getLeft()) );
			return node;
		}
		else 
		{
			node.setRight( insert(insertedString, node.getRight()) );
			return node;
		}
	}
	
	public boolean find(String searchString)
	{

		return find(searchString, root);
	}

	public boolean find(String searchString, Node node)
	{
		//If at the end of the tree and continues to the leave's children (null) 
		//	then searchString not in tree and return false
		if(node == null)
		{
			return false;
		}
		else if(searchString.compareTo(node.getData()) < 0)
		{
			return find(searchString, node.getLeft());
		}
		else if (searchString.compareTo(node.getData()) > 0)
		{
			return find(searchString, node.getRight());
		}
		return true;

	}

	//Call private method that traverses tree
	public void delete(String deleted)
	{
			root = delete(deleted, root);
	}

	private Node delete(String value, Node node)
	{ 
		//Base Case
		if(node == null)
			return null;
		//Recursive: check if value is in tree, then move down tree
		if(node.getData().equals(value))
		{
			if(node.getLeft() == null)
			{
				return node.getRight();
			}
			else if (node.getRight()==null)
			{
				return node.getLeft();
			}
			
		}
		if(node.getRight().getLeft() == null)
		{
			node.setData(node.getRight().getData());
			node.setRight(node.getRight().getRight());
			return node;
		}
		else		
		{
			node.setData(deleteSmallest(node.getRight()));
			return node;
		}
	}
	
	//Helper method to find node with smallest data on left side
	public String deleteSmallest(Node node) {
	      if (node.getLeft().getLeft() == null) {
	         String smallest = node.getLeft().getData();
	         node.setLeft(node.getLeft().getRight()) ;
	         return smallest;
	      } 
	      
	      return deleteSmallest(node.getLeft());
	}
	
	public String toStringInOrder()
	{
		//Trim on the returned string from function where code happens
		String in = "";
		return toStringInOrder(root,in).trim();
	}
	//Recursive: left, root, right
	private String toStringInOrder(Node node, String in)
	{
		if (node !=  null) {
			in = toStringInOrder(node.getLeft(), in);
			in += node.getData() + " ";
			in = toStringInOrder(node.getRight(), in);
			
			return in;
		}
		return in;
	}

	public String toStringPreOrder()
	{
		String pre = "";
		return toStringPreOrder(root, pre).trim();
	}
	//Recursive: root, left, right
	private String toStringPreOrder(Node node, String pre)
	{
		if (node != null) {
			pre += node.getData() + " ";
			pre = toStringPreOrder(node.getLeft(), pre);
			pre = toStringPreOrder(node.getRight(), pre);
			
			return pre;
		}
		return pre;
		//Weird errors when using this check:
     /* if(node == null)
			return "";
		String data = node.getData();
		return  data + " " + toStringPreOrder(node.getLeft())  + toStringPreOrder(node.getRight());
	 */	
	}
	//For testing purposes
	public void print()
	{
		String str = print(root);
		str.trim();
		//System.out.println("Tested trim" + str);
	}
	public String print(Node node)
	{
		if(node == null) 
			return "";
		print(node.getLeft());
		System.out.print(node.getData() + " ");
		print(node.getRight());
		return node.getData();
	}
}


