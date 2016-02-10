public class TreeNode
{
  private Object value;
  private TreeNode left;
  private TreeNode right;

  // Constructors:

  public TreeNode(Object initValue)
  {
    value = initValue;
    left = null;
    right = null;
  }

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
