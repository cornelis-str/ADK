import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] chocolate = {4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 9, 8, 2, 7, 1, 2, 3, 8, 1, 9, 2, 7, 3, 8, 1, 7, 2, 8, 1, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 9, 8, 2, 7, 1, 2, 3, 8, 1, 9, 2, 7, 3, 8, 1, 7, 2, 8, 1, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 9, 8, 2, 7, 1, 2, 3, 8, 1, 9, 2, 7, 3, 8, 1, 7, 2, 8, 1, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 4, 5, 2, 1, 6, 9, 8, 2, 7, 1, 2, 3, 8, 1, 9, 2, 7, 3, 8, 1, 7, 2, 8, 1};
        String path = checkLast(chocolate);
        System.out.println("\n" + path);
        System.out.println();

        /*
        int[][] square = Cov(8);

        for(int[] i : square){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        */
    }

    private static String checkLast(int[] chocolate){
        int len = chocolate.length + 1;
        int[][] m = new int[len][len];
        String[][] pathTo = new String[len][len];

        pathTo[0][0] = "";
        m[0][0] = 0;
        int k = 1;
        for(int i = 1; i < len; i++){
            m[0][i] = m[0][i-1] + chocolate[chocolate.length - i]*k;
            pathTo[0][i] = pathTo[0][i-1] + " right";
            k++;
        }
        k = 1;
        for(int i = 1; i < len; i++){
            m[i][0] = m[i-1][0] + chocolate[i - 1]*k;
            pathTo[i][0] = pathTo[i-1][0] + " left";
            k++;
        }

        for(int i = 1; i < len; i++){
            for(int j = 1; j < len; j++){
                k = i + j;
                int end = chocolate.length-j;
                int right = m[i-1][j] + chocolate[i-1]*k;
                int left = m[i][j-1] + chocolate[end]*k;
                if(right > left){
                    m[i][j] = right;
                    pathTo[i][j] = pathTo[i-1][j] + " left";
                } else {
                    m[i][j] = left;
                    pathTo[i][j] = pathTo[i][j-1] + " right";
                }
            }
        }

        int[] max = {0, 0};
        for(int i = 0; i < len; i++){
            if(m[i][len - 1 - i] > m[max[0]][max[1]]){
                max[0] = i;
                max[1] = len - 1 - i;
            }
        }

        return pathTo[max[0]][max[1]];
    }

    static int[][] matr;

    public static int[][] Cov(int m) {
        int n = (int) (Math.log(m)/Math.log(2));
        matr = new int[m][m];
        matr[1][m - 1] = 0 ;
        Cover(0, 0, n, 3, 0);
        return matr;
    }

    public static int Cover(int x, int y, int n, int quadrant, int lastL) {
        lastL += 1;
        int half = (int) (Math.pow(2, n) / 2);
        int xpos = x + half;
        int ypos = y + half;
        if(quadrant == 1) {
            matr[xpos - 1][ypos - 1] = lastL;
            matr[xpos - 1][ypos] = lastL;
            matr[xpos][ypos - 1] = lastL;
        } else if(quadrant == 2) {
            matr[xpos - 1][ypos - 1] = lastL;
            matr[xpos - 1][ypos] = lastL;
            matr[xpos][ypos] = lastL;
        } else if(quadrant == 3) {
            matr[xpos - 1][ypos - 1] = lastL;
            matr[xpos][ypos - 1] = lastL;
            matr[xpos][ypos] = lastL;
        } else {
            matr[xpos - 1][ypos] = lastL;
            matr[xpos][ypos - 1] = lastL;
            matr[xpos][ypos] = lastL;
        }
        if (n == 1) {
            return lastL;
        }
        if (quadrant == 1) {
            lastL = Cover(x, y, n - 1, 1, lastL);
            lastL = Cover(x, y + half, n - 1, 2, lastL);
            lastL = Cover(x + half, y, n - 1, 3, lastL);
            lastL = Cover(x + half, y +half, n - 1, 1, lastL);
        } else if (quadrant == 2) {
            lastL = Cover(x, y, n - 1, 1, lastL);
            lastL = Cover(x, y + half, n - 1, 2, lastL);
            lastL = Cover(x + half, y, n - 1, 2, lastL);
            lastL = Cover(x + half, y + half, n - 1, 4, lastL);
        } else if (quadrant == 3) {
            lastL = Cover(x, y, n - 1, 1, lastL);
            lastL = Cover(x, y + half, n - 1, 3, lastL);
            lastL = Cover(x + half, y, n - 1, 3, lastL);
            lastL = Cover(x + half, y + half, n - 1, 4, lastL);
        } else {
            lastL = Cover(x, y, n - 1, 4, lastL);
            lastL = Cover(x, y + half, n - 1, 2, lastL);
            lastL = Cover(x + half, y, n - 1, 3, lastL);
            lastL = Cover(x + half, y + half, n - 1, 4, lastL);
        }
        return lastL;
    }

}
