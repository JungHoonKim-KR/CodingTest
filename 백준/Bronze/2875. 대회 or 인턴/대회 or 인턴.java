import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int girl  = Integer.parseInt(st.nextToken());
        int man =  Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        while(k != 0){
            if(2 * man >= girl){
                man--;
            }
            else girl--;
            k--;
        }
        if(girl / 2  < man)
            System.out.println(girl/2);
        else System.out.println(man);







    }
}