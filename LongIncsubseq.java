import java.util.*;
class liss{

public static void main(String s[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int ar[]=new int[n];
int arr[]=new int[n];
for(int i=0;i<n;i++){
ar[i]=in.nextInt();
arr[i]=1;
}
int max=0;
for(int i=0;i<n;i++){
for(int j=0;j<i;j++){
if(ar[i]>ar[j]){
arr[i]=Math.max(arr[j]+1,arr[i]);
if(arr[i]>max) max=arr[i];
}

}
}
System.out.println("max sum length is :"+max);





}



}
