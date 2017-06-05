import java.util.*;
import java.lang.*;
class perm{
String s1,s2;
void setData(String str,String str2){
	s1=new String(str);
    s2=new String(str2);
}
boolean isPerm(){
//without any additional ds solution o(nlgn)

if(s1.length()!=s2.length()) return false;

	for(int i=0;i<s1.length();i++){
		
	}

    for(int j=i+1;j<s.length();j++){
			if(s.charAt(i)==s.charAt(j)) return false;
		}
return true; 

}
public static void main(String ar[]){
Scanner in =new Scanner(System.in);
String s=in.next();
unique obj=new unique();
obj.setData(s);
System.out.println("all chars in string are :"+(obj.isUnique()?" ":" not")+" unique");

}

}
