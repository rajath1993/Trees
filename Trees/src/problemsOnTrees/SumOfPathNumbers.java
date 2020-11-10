package problemsOnTrees;

public class SumOfPathNumbers {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(7);
		root.right = new Node(9);
		root.right.left = new Node(2);
		root.right.right = new Node(9);
		
		String num = "";
		int sum = 0;
		sum = findSumOfPath(root,num,sum);
		System.out.println(sum);
	}
	/*keep adding the number to the string from root to leaf, finally add left subtree with right subtree*/
	public static int findSumOfPath(Node root,String num,int sum) {
		if(root == null) return 0;
		num+=root.val;
		if(root.left == null && root.right == null) {
			sum=Integer.parseInt(num);
			return sum;
		}
		
		return findSumOfPath(root.left,num,sum)+findSumOfPath(root.right,num,sum);
	}

}
