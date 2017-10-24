public class Node{
	
	private String data;
	private Node left, right;
	
	//Excess constructor
	/*public Node()
	{
		data = null;
		left = null;
		right = null;
	}*/
	
	//Changed from Comparable obj to String obj, per professor's recommendation
	public Node(String obj)
	{
		data = obj;
		left = null;
		right = null;
	}
	
	
	//Getters and setters for data, left, right
	public String getData()
	{
		return data;
	}
	public void setData(String obj)
	{
		data = obj;
	}
	
	public Node getLeft()
	{
		return left;
	}
	public void setLeft(Node tmp)
	{
		left = tmp;
	}
	
	public Node getRight()
	{
		return right;
	}
	public void setRight(Node tmp)
	{
		right = tmp;
	}
	
}