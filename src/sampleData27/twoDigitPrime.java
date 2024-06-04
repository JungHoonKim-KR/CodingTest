import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class twoDigitPrime {
    static boolean primeJudgement(int n){
        if(n <= 1)
            return false;
        if(n % 2 == 0)
            return n == 2 ? true : false;

        for(int i =3; i<=Math.sqrt(n); i+=2){
            if(n % i == 0) return false;
        }
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("twoDigitPrime.inp"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("twoDigitPrime.out"));
        int testCaseCount = Integer.parseInt(br.readLine().trim());
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for(int i =0; i<=9; i++){
            list.add(new HashSet<>());
        }
        for(int tc=0;tc<testCaseCount;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int count=0;
            boolean isPrime = false;
            for(int num=a; num<=b;num++){
                String s = String.valueOf(num);
                for(int i =0; i<s.length()-1; i++){
                    int num1=  s.charAt(i) - '0';
                    if(num1 ==0) continue;
                    for(int j = i+1; j<s.length(); j++){
                        int num2 = s.charAt(j) - '0';
                        int num12 =Integer.parseInt(""+num1+num2);
                        int num21 =Integer.parseInt(""+num2+num1);
                        if(list.get(num1).contains(num2)){
                            count++;
                            isPrime = true;
                            break;
                        }else {
                            if (primeJudgement(num12) || (num2 != 0 && primeJudgement(num21))) {
                                list.get(num1).add(num2);
                                list.get(num2).add(num1);
                                count++;
                                isPrime = true;
                                break;
                            }
                        }
                    }
                    if(isPrime){
                        isPrime=false;
                        break;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.close();
    }
}
