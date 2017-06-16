import java.util.*;
class KadaneResult{
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }
    
class maxs{
 static KadaneResult kadane(int arr[]){
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for(int i=0; i < arr.length; i++){
            maxSoFar += arr[i];
            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }
            if(max < maxSoFar){
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }
static int maxVal;
static int leftB;
static int rightB;
static int upB;
static int lowB;
public static void max(int[][] ar){
int rows=ar.length;
int cols=ar[0].length;
int temp[]=new int[rows];
//maxs ma= new maxs();
for(int left=0;left<cols;left++){
	for(int i=0;i<rows;i++) temp[i]=0;
	
for(int right=left;right<cols;right++){
for(int i=0;i<rows;i++){
temp[i]+=ar[i][right];
}
KadaneResult ks = kadane(temp);
if(ks.maxSum>maxVal){
maxVal=ks.maxSum;
leftB=left;
rightB=right;
upB=ks.start;
lowB=ks.end;
}

}

}

}
public static void main(String s[]){
//Scanner in=new Scanner(System.in);
int input[][] = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
//maxs m=new maxs();
max(input);
System.out.println(maxVal);
}


}

   


