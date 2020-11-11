package problemsOnTrees;

public class CountPathToSum {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(7);
		root.right = new Node(9);
		root.left.left = new Node(6);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		root.left.right = new Node(5);
		
		int sum = 12;
		int res = countPathToSum1(root,sum);
		System.out.println(res);
	}
	
	public static int countPathToSum1(Node root,int sum) {
		if(root == null) return 0;
		return countPathToSum1(root.left,sum)+countPathToSum1(root.right,sum)+countPathToSum2(root,sum);
	}
	
	public static int countPathToSum2(Node root,int sum) {
		if(root==null) return 0;
		int count = 0;
		if(root.val == sum) {
			count = 1;
		}
		
		int newSum = sum - root.val;
		count+=countPathToSum2(root.left,newSum);
		count+=countPathToSum2(root.right,newSum);
		
		return count;
		
	}
	
	/*
	 * Time Complexity: O(n*2) -> we need to traverse each node
	 * */

}
