import java.util.*;
class prime{
public static void main(String s[]){
Scanner in =new Scanner(System.in);
int n=in.nextInt();
int c=0;
for(int i=0;i<n;i++){
boolean b=false;
for(int j=2;j<Math.sqrt(n);j++){
if(i%j==0&&i!=j) { 
b=true;
System.out.println("num:"+i+" "+j);
}

}
if(!b){
//b=false;
c++;
System.out.println(i);
}
}
System.out.println("total:"+c);

}}
