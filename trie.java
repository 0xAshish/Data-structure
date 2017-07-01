import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 class trie {
        ArrayList<trie> child;
        trie next;
        char data;
        int count;
        trie(char c){
            this.data=c;
            next=null;
            count=1;
            child=new ArrayList();
        }
     public trie find(char s,ArrayList<trie> tr){
         Iterator itr=tr.listIterator();
         while(itr.hasNext()){
             trie node=(trie)itr.next();
             if(node.data==s){
                 return node;
             }
         }
         return new trie('$');
     }
        public int search(String s,trie head){
            int i=0;
            trie prev=head;boolean b=true;
            //head=head.next;
         loop:    while(b){
             
           trie node;
             try{
           node=head.find(s.charAt(i),head.child);
             }catch(Exception e){
                 node=new trie('$');
             }
                if(node.data!='$'){
                   /// node.count++;
                    head=node;    i++;
                    prev=node;
                   // System.out.println(node.data+" "+node.count+" "+i+" "+s.length());
                    if(i==s.length()) return node.count;
                    
                   
            }
            else{ // add corner case like in between 
                break loop;
              
            }
        } return 0;
           
        }
        public void insert(String s, trie head){
            boolean b=true;
         //   System.out.println("insert "+s);
            trie prev=head;
            
 
            int i=0;
            char lastChar='0';
         loop:    while(b){
             
           trie node;
             try{
           node=head.find(s.charAt(i),head.child);
             }catch(Exception e){
                 node=new trie('$');
             }
                if(node.data!='$'){
                    node.count++;
                    head=node;   i++;
                    prev=node;
                   // System.out.println(node.data+" "+node.count);
            }
            else{ // add corner case like in between 
                break loop;
              
            }
        }
            head=prev;
            while(i!=s.length()){
                trie temp=new trie(s.charAt(i));
                head.child.add(temp);
                head=temp;
                i++;
              //  System.out.println(temp.data+" inserted");
            }
    }
    }
class Solution {
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        trie head=new trie('0');
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
           if(op.compareTo("add")==0) head.insert(contact,head);
            if(op.compareTo("find")==0) System.out.println(head.search(contact,head));
            
        }
    }
}
/*
input
4
add hack
add hackerrank
find hac
find hak


Output

2
0

*/

