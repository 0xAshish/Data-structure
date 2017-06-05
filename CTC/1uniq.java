import java.util.*;
import java.lang.*;
class unique{
String s;
void setData(String str){
	s=new String(str);
}
boolean isUnique(){
//without any additional ds solution o(nlgn)
	for(int i=0;i<s.length();i++){
		for(int j=i+1;j<s.length();j++){
			if(s.charAt(i)==s.charAt(j)) return false;
		}
	}
return true; 
/*other possible solution 
bloom filter insert each char in bloom filter and if that already exits then return false //o(n) solution
create a array of possible size of all char and increament arr[char] on first occurence and for second return false// count sort kinda
insert into hash set java hash set will return true or false 
*/
}
public static void main(String ar[]){
Scanner in =new Scanner(System.in);
String s=in.next();
unique obj=new unique();
obj.setData(s);
System.out.println("all chars in string are :"+(obj.isUnique()?" ":" not")+" unique");

}

}
