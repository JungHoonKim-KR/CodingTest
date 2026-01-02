import java.io.*;
import java.util.*;

class Query{
    String num;
    int strike, ball;

    Query(String num, int strike, int ball){
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}

public class Main {
    static List<Query> queryList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while(n -->0){
            st = new StringTokenizer(br.readLine());

            queryList.add(new Query(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int result = 0;
        for(int i  =1; i<=9; i++){
            for(int j=1; j<=9; j++){
                for(int k=1; k<=9; k++){
                    if(i == j || j == k || i == k) continue;
                    if(isAnswer(new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(k)})){
                       result++;
                    }
                }
            }
        }

        System.out.println(result);

    }

    static boolean isAnswer(String str[]){
        int strike = 0;
        int ball = 0;
        for(Query q : queryList){
            strike = 0;
            ball = 0;
            for(int i = 0; i<3; i++){
                if(String.valueOf(q.num.charAt(i)).equals(str[i])){
                    strike++;
                }
                else if(q.num.contains(str[i])){
                    ball++;
                }
            }
            if(q.strike != strike || q.ball != ball){
                return false;
            }
        }
        return true;
    }
}