package sampleData34;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class computation {
    static String operation(String data){
        StringTokenizer st =new StringTokenizer(data);
        BigDecimal a = new BigDecimal(st.nextToken());
        String op = st.nextToken();
        BigDecimal b = new BigDecimal(st.nextToken());
        BigDecimal result= BigDecimal.ZERO;
        switch (op){
            case "+":
                result = a.add(b);
                break;
            case "-":
                result = a.subtract(b);
                break;
            case"*":
                result = a.multiply(b);
                break;
            case "/":
                result = a.divide(b, 0, RoundingMode.DOWN);
                break;
        }
        return formatting(result);
    }
    static String formatting(BigDecimal data){
        return data.stripTrailingZeros().toPlainString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sampleData34/1.inp"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("double.out"));
        int T = Integer.parseInt(bufferedReader.readLine());
        for(int tc =0; tc < T; tc++) {
            String s = bufferedReader.readLine();
            bufferedWriter.write(operation(s)+"\n");

        }

        bufferedWriter.close();
    }
}
