package problemsOnTrees;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(2);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.right.right.left = new Node(5);
		root.right.right.right = new Node(1);
		
		int sum = 22;
		List<List<Integer>> result = hasPathSum(root,sum);
		System.out.println(result);
	}
	
	public static List<List<Integer>> hasPathSum(Node root,int sum){
		List<List<Integer>> result = new ArrayList<>();
		
		helper(root,sum,new ArrayList<>(),result);
		
		return result;
	}
	
	public static void helper(Node root,int sum,List<Integer> current,List<List<Integer>> result) {
		if(root == null) return;
		
		current.add(root.val);
		if(root.val == sum && root.left == null && root.right == null) {
			result.add(new ArrayList<>(current));
		}
		
		helper(root.left,sum-root.val,current,result);
		helper(root.right,sum-root.val,current,result);
		
		current.remove(current.size()-1);
	}
	/*
	 * 			1
	 * 		7		9
	 * 	  4   5	  2   7
	 * 
	 * 
	 * res [[1,7,4],]
	 * */

}
