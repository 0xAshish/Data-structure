import java.util.*;
class TS{
public static Stack st=new Stack();
public static void DFS(int node,boolean[] visited,Set<Integer>[] adj){
if(visited[node]) return;
else {
for(Integer i:adj[node]){
if(!visited[i]){
DFS(i,visited,adj);
visited[i]=true;
st.add(i);

}
}

}




}



public static void main(String ss[]){
Scanner in=new Scanner(System.in);
int n=in.nextInt();
Set<Integer> adj[]=new Set[n];
for(int i=0;i<n;i++){
adj[i]=new HashSet<>();
}
System.out.println("enter number of pair of edges");
int m=in.nextInt();
for(int i=0;i<m;i++){
int a=in.nextInt();
int b=in.nextInt();
if(a!=b) adj[a].add(b);
}
boolean visited[]=new boolean[n];
for(int i=0;i<n;i++){
if(!visited[i]){ DFS(i,visited,adj); st.add(i);}
}

while(!st.empty()) System.out.print(st.pop()+" ");

}
}
