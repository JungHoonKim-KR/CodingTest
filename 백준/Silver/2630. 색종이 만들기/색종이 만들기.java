import java.io.*;
import java.util.*;


public class Main {
    static int arr[][];
    static int blue=0;
    static int white=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i =0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        find(0,0,n);

        System.out.println(white);
        System.out.println(blue);


    }

    static void find(int x, int y, int weight){
        int target = arr[x][y];
        for(int i=x; i<x+weight; i++){
            for(int j=y; j<y+weight; j++){
                if(arr[i][j] != target){
                    int newWeight = weight/2;
                    find(x,y,newWeight);
                    find(x+newWeight,y,newWeight);
                    find(x,y+newWeight,newWeight);
                    find(x+newWeight,y+newWeight,newWeight);
                    return;
                }
            }
        }
        if(target==0)
            white++;
        else blue++;
    }

}
