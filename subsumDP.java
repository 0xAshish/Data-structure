import java.util.*;
class subsum{
public static boolean isPossible(int[] ar,int value){
boolean t[][]=new boolean[ar.length+1][value+1];
for(int j=0,i=0;i<ar.length;i++) t[i][j]=true;
for(int i=0,j=0;j<=value;j++) t[i][j]=false;

for(int i=1;i<=ar.length;i++){
for(int j=1;j<=value;j++){
if(j<ar[i-1]) t[i][j]=t[i-1][j];
else{
t[i][j]=t[i-1][j]||t[i-1][j-ar[i-1]];
}


}}

return t[ar.length][value];
}

public static void main(String arr[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int ar[]=new int[n];
for(int i=0;i<n;i++){
ar[i]=in.nextInt();
}
int value=in.nextInt();

System.out.println(isPossible(ar,value));

}

}
