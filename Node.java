public class Node{
	int data;
	Node left;
	Node right;
	int height;

	public static Node newNode(int data){
		Node n=new Node();
		n.data=data;
	//	n.left=null;
	//	n.right=null;
		n.height=0;
	return n;
}
public static void inOrder(Node root){
	if(root!=null){
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
}

}
