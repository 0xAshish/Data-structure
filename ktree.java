import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
static int ar[][];
static int parent[];
    
    static int dist(int i,int j){
       int counta=0,countb=0;
        if(ar[i][j]!=0) return ar[i][j];
       int para=i,parb=j;
        while(para!=parb){
           // System.out.println(para+" "+parb);
	if(parent[para]==0&&parent[parb]==0){ 
		if(para!=parb) return 0;
	 		else return counta+countb;
	} 
            if(parent[para]!=0){
                para=parent[para];
                counta++;
            }
            if(parent[parb]!=0){
                parb=parent[parb];
                countb++;
            }
            if(counta>parent.length||countb>parent.length) return 0;
        }
        ar[i][j]=counta+countb;
        ar[j][i]=counta+countb;
        return counta+countb;
    }
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        ar=new int[n+1][n+1];
        parent=new int[n+1];
        int round=1000000007;
        for(int i=0;i<n-1;i++){
        int a=in.nextInt();
            int b=in.nextInt();
            ar[a][b]=1;
            ar[b][a]=1;
            parent[b]=a;
        }
        for(int i=0;i<k;i++){
            int m=in.nextInt();
         //   System.out.println(m);
            int arr[]=new int[m];
            for(int j=0;j<m;j++){
                arr[j]=in.nextInt();
            }
            if(m<=1){
                System.out.println("0");
            }else{
                int output=0;
                for(int l=0;l<m;l++){
                    for(int o=l+1;o<m;o++){
                        output+=(arr[l]*arr[o]*dist(arr[l],arr[o]));
                    }
                }
                System.out.println(output%round);
            }
            
        }
        
    }
}
