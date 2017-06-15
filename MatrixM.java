import java.util.*;
class mmp{
public static int calculate(int[] arr){
int temp[][]=new int[arr.length][arr.length];
for(int l=2;l<arr.length;l++){
for(int i=0;i<arr.length-l;i++){
int j=i+l;
temp[i][j]=4563210;
for(int k=i+1;k<j;k++){
temp[i][j]=Math.min(temp[i][j],temp[i][k]+temp[k][j]+arr[i]*arr[k]*arr[j]);
}
}


}
return temp[0][arr.length-1];
}
public static void main(String s[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int ar[]=new int[n];
for(int i=0;i<n;i++){
ar[i]=in.nextInt();
}
System.out.println(calculate(ar));

}


}
