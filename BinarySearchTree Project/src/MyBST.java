// Implements a BST with TreeNode nodes

// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.
/**
 * @author Nomi Ringach
 * @since 3.6.16
 * @version 1.0.0
 * @param <E> The type of object that this BST will hold
 */
@SuppressWarnings(value={"unchecked"})
public class MyBST <E>
{
	private TreeNode root, currentParent;  // holds the root of this BST
	private int currentDirection;		   // the direction that was last used by remove

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value)
	{
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value)
	{
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value)
	{
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	@Override
	public String toString()
	{
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value)
	{
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<E>)value).compareTo((E)node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value)
	{
		if (node == null)
			return new TreeNode (value);
			//return node = new TreeNode (value);
		else if (((Comparable<E>)node.getValue()).compareTo((E)value) <= 0)  //value should be on right
			node.setRight(add(node.getRight(), value));
		else
			node.setLeft(add(node.getLeft(), value));								 //value should be on left
		return node;
	}

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
//	private TreeNode remove(TreeNode node, Object value)
//	{
//		int compared = ((Comparable<E>)node.getValue()).compareTo((E)value);
//		if(compared < 0) //value is greater than node
//		{
//			currentParent = node;
//			currentDirection = 1;
//			remove(node.getRight(), value);
//		}
//		else if (compared > 0)
//		{
//			currentParent = node;
//			currentDirection = -1;
//			remove(node.getLeft(), value);
//		}
//		else
//		{
//			if(node.equals(root))
//				root = removeRoot(node);
//			else
//			{
//				TreeNode newChild = removeRoot(node);
//				if (currentDirection == -1)
//					currentParent.setLeft(newChild);
//				else
//					currentParent.setRight(newChild);
//			}
//		}
//		return node;
//	}

	 private TreeNode remove(TreeNode root, Object key) {
	        if (root == null) return null;

	        int cmp = ((Comparable<E>)key).compareTo((E)root.getValue());
	        if      (cmp < 0) 
	        	root.setLeft(remove(root.getLeft(),  key));
	        else if (cmp > 0) 
	        	root.setRight(remove(root.getRight(), key));
	        else 
	        { 
	            if (root.getRight() == null) 
	            	return root.getLeft();
	            else if (root.getLeft()  == null) 
	            	return root.getRight();
	            TreeNode temp = root;
	            root = getMin(temp.getRight());
	            root.setRight(removeMin(temp.getRight()));
	            root.setLeft(temp.getLeft());
	        } 
	        return root;
	    } 
	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root)
	{
		if(root == null)
			return null;
		else if (root.getRight() == null)
			return root.getLeft();
		else if (root.getLeft() == null)
			return root.getRight();
		else
		{
			TreeNode temp = root.getLeft();
			root = getMin(root.getRight());
			root.setRight(removeMin(root.getRight()));
			root.setLeft(temp);
		}
		return root;
	}

	private TreeNode removeMin(TreeNode root)
	{
		if (root == null)
			return null;
		else if (root.getLeft()  == null)
			return root.getRight();
		root.setLeft(removeMin(root.getLeft()));
		return root;
	}
	
	private TreeNode getMin(TreeNode root)
	{
		if (root == null)
			return null;
		else if (root.getLeft()!=null)
			return getMin(root.getLeft());
		else
			return root;
	}
	
	private String toString(TreeNode node)
	{
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}

}
