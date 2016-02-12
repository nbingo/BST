
public class BSTTester {

	public static void main(String[] args) {
		MyBST<Integer> myBST = new MyBST<Integer>();
		myBST.add(1);
		myBST.add(2);
		myBST.add(0);
		myBST.add(5);
		myBST.add(-1);
		myBST.add(3);
		myBST.add(-2);
		myBST.add(-5);
		myBST.remove(1);
		myBST.remove(5);
		System.out.println(myBST);
	}

}
