
import java.util.*;

class kanpsack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int item[] = new int[n+1];
        int w[] = new int[n+1];
        for (int i = 1; i <=n; i++) {
            item[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int m = in.nextInt();
        int t[][] = new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                }
                else if(w[i]>j){
                t[i][j]=t[i-1][j];
                }else {
                t[i][j]=Math.max(t[i-1][j],w[i]+t[i-1][j-w[i]]);
                    
                }
            }
        }
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(t[i][j]+" ");
            }System.out.println();  
        }
    }
}
