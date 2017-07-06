import java.util.*;
class minJump{
public static void main(String ss[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int ar[]=new int[n];
for(int i=0;i<n;i++)ar[i]=in.nextInt(); 

int dp[]=new int[n];
int sol[]=new int[n];
dp[0]=0;
for(int i=1;i<n;i++) dp[i]=Integer.MAX_VALUE;
for(int i=1;i<n;i++){
for(int j=0;j<i;j++){
if(i<=ar[j]+j){
dp[i]=Math.min(dp[i],dp[j]+1);
//if(dp[i]<dp[j]+1) 
sol[i]=j;
}

}

}

for(int i=0;i<n;i++){

System.out.println(dp[i]+" "+sol[i]);
}

}}
