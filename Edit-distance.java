import java.util.*;
class Editdis{
public static void main(String s[]){
Scanner in=new Scanner(System.in);
String s1=in.next();
String s2=in.next();
int t[][]=new int[s1.length()+1][s2.length()+1];
for(int i=1;i<=s1.length();i++){
for(int j=1;j<=s2.length();j++){
if(s1.charAt(i-1)==s2.charAt(j-1)){
t[i][j]=t[i-1][j-1];
}else{
t[i][j]=Math.min(t[i-1][j-1],Math.min(t[i-1][j],t[i][j-1]))+1;
}

}
}
System.out.println(t[s1.length()][s2.length()]);
}



}
