import java.util.*;
class mcp{
public static void main(String ss[]){
Scanner in=new Scanner(System.in);
int m=in.nextInt();
int n=in.nextInt();
int ar[][]=new int[m][n];

int dp[][]=new int[m][n];
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
ar[i][j]=in.nextInt();
}
}
dp[0][0]=ar[0][0];
for(int i=1;i<m;i++){
dp[i][0]=dp[i-1][0]+ar[i][0];
}
for(int i=1;i<n;i++){
dp[0][i]=dp[0][i-1]+ar[0][i];
}
for(int i=1;i<m;i++){
for(int j=1;j<n;j++){
dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+ar[i][j];
}}

System.out.println("from 0 0 to "+n+" "+n+" :"+dp[m-1][n-1]);

}

}
