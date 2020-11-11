package problemsOnTrees;

public class SequencePath {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(0);
		root.right = new Node(1);
		root.left.left = new Node(1);
		root.right.left = new Node(6);
		root.right.right = new Node(5);
		
		int[] sequence = new int[] {1,1,6};
		int index = 0;
		boolean res = findPath(root,sequence,index);
		System.out.println(res);
	}
	
	public static boolean findPath(Node root,int[] sequence,int index) {
		if(root == null) return false;
		if(index>sequence.length-1||root.val != sequence[index]) return false;
		
		if(root.left==null && root.right==null && index == sequence.length-1) return true;
		
		return findPath(root.left,sequence,index+1)||findPath(root.right,sequence,index+1);
	}
}
