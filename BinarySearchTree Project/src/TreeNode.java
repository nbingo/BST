/**
 * A basic node in a binary tree that has a value, a left node and a right node.
 * @author Nomi
 */
public class TreeNode
{
  private Object value;
  private TreeNode left;
  private TreeNode right;

  // Constructors:
  /**
   * Creates a new node with the given value and null left and right nodes
   * @param initValue The value that this node will hold
   */
  public TreeNode(Object initValue)
  {
    this(initValue, null, null);
  }
  /**
   * Creates a new node with the given initial value and left and right nodes.
   * @param initValue The initial value that this node will hold
   * @param initLeft The node on the left (less than this node)
   * @param initRight The node on the right (more than this node)
   */
  public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  // Methods:
  @Override
  public String toString() { return value.toString(); }
  public Object getValue() { return value; }
  public TreeNode getLeft() { return left; }
  public TreeNode getRight() { return right; }
  public void setValue(Object theNewValue) { value = theNewValue; }
  public TreeNode setLeft(TreeNode theNewLeft) { return left = theNewLeft; }
  public TreeNode setRight(TreeNode theNewRight) { return right = theNewRight; }
}
