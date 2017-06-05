import java.util.*;
public class AVLTree{
    //avl tree with +-1 height balance factor
Node rightRotate(Node root){
    Node newNode=root.left;
    root.left=root.left.right;
    newNode.right=root;
    root.height=setHeight(root);
    newNode.height=setHeight(newNode);
    return newNode;
}
Node leftRotate(Node root){
    Node newNode=root.right;
    root.right=root.right.left;
    newNode.left=root;
    root.height=setHeight(root);
    newNode.height=setHeight(newNode);
    return newNode;
}
int setHeight(Node root){
    if(root==null) return 0;
    return 1+Math.max((root.left!=null?root.left.height:0),(root.right!=null?root.right.height:0));
}
int height(Node root){
    if(root==null) return 0;
    return root.height;
}
int balance(Node left,Node right){
    return height(left)-height(right);
}
Node insert(Node root,int data){
if(root==null){System.out.println("insert it: "+data); return Node.newNode(data); }

if(root.data>=data){ root.left=insert(root.left, data);}
else { root.right=insert(root.right, data);}
int balance=balance(root.left, root.right);
if(balance>1){
    if(height(root.left.left)>=height(root.left.right)){
        root=rightRotate(root);
    }else{
        root.left=leftRotate(root.left);
        root=rightRotate(root);
    }
}else if(balance<-1){
    if(height(root.right.right)>=height(root.right.left)){
        root=leftRotate(root);
    }else{
        root.right=rightRotate(root.right);
        root=leftRotate(root);
    }
}else{
    root.height=setHeight(root);
}
return root;
}
public static void main(String s[]){
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    AVLTree avl=new AVLTree();
    Node root=null;
  //  while(n-->0){
    for(int i=0;i<n;i++){
        int data=in.nextInt();
       System.out.println("insert: "+data);
        root=avl.insert(root, data);
    }
    if(root!=null) System.out.println("root"+root.data+"h: "+avl.balance(root.left,root.right));
    Node.inOrder(root);
    System.out.println();
}
}