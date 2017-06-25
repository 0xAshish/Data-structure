import java.util.*;
class js{
int start;
int end;
int value;
public static boolean noOverlap(js a,js b){
if(a.end<=b.start) return true;
return false;


}

public static void main(String s[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
js ar[]=new js[n];
int value[]=new int[n];
for(int i=0;i<n;i++){
ar[i]=new js();
ar[i].start=in.nextInt();

ar[i].end=in.nextInt();
ar[i].value=in.nextInt();
value[i]=ar[i].value;

}

for(int i=0;i<n;i++){
for(int j=0;j<=i;j++){
if(noOverlap(ar[j],ar[i])){
value[i]=Math.max(value[i],value[j]+ar[i].value);
}

}

}
for(int i=0;i<n;i++){
System.out.println(value[i]+" ");
}
}
}
