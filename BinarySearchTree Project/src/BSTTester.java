
public class BSTTester {

	public static void main(String[] args) {
		MyBST<Integer> myBST = new MyBST<Integer>();
//		myBST.add(1);
//		myBST.add(2);
//		myBST.add(0);
//		myBST.add(5);
//		myBST.add(-1);
		for (int i = -5; i <= 5; i++)
			myBST.add(i);
		myBST.remove(1);
		myBST.remove(5);
		System.out.println(myBST);
	}

}
