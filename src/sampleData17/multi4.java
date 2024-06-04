import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class multi4 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("multi4.inp");
        File file2 = new File("multi4.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int caseNum = Integer.parseInt(bufferedReader.readLine());
        for(int i =0;i<caseNum;i++){
            int num = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int data[] = new int[num];
            for(int j =0;j<num;j++){
                data[j] = Integer.parseInt(st.nextToken());
            }
            int [] sorted = Arrays.stream(data).sorted().toArray();

            BigInteger maxtotal1=BigInteger.ONE;
            BigInteger maxtotal2=BigInteger.ONE;
            BigInteger maxtotal3=BigInteger.ONE;
            BigInteger mintotal1=BigInteger.ONE;
            BigInteger mintotal2=BigInteger.ONE;
            BigInteger mintotal3=BigInteger.ONE;
            BigInteger mintotal4=BigInteger.ONE;
            for(int j =num-1;j>num-5;j--){
                maxtotal1 = maxtotal1.multiply(BigInteger.valueOf(sorted[j]));
            }

            for(int j =0;j<4;j++){
                maxtotal2 = maxtotal2.multiply(BigInteger.valueOf(sorted[j]));
            }
            for(int j=0;j<2;j++){
                maxtotal3 = maxtotal3.multiply(BigInteger.valueOf(sorted[j]));
                maxtotal3 = maxtotal3.multiply(BigInteger.valueOf(sorted[sorted.length-1-j]));
            }
            System.out.println(maxtotal1 + " "+maxtotal2+" "+maxtotal3);
            for(int j=0;j<3;j++){
                mintotal1 = mintotal1.multiply(BigInteger.valueOf(sorted[j]));
            }
            mintotal1 = mintotal1.multiply(BigInteger.valueOf(sorted[sorted.length-1]));

            for(int j=num-1;j>num-4;j--){
                mintotal2 =  mintotal2.multiply(BigInteger.valueOf(sorted[j]));
            }
            mintotal2 =  mintotal2.multiply(BigInteger.valueOf(sorted[0]));
            for(int j=0;j<4;j++){
                mintotal3 = mintotal3.multiply(BigInteger.valueOf(sorted[j]));
            }
            for(int j=0;j<4;j++){
                mintotal4 = mintotal4.multiply(BigInteger.valueOf(sorted[sorted.length-1-j]));
            }

            fileWriter.write(mintotal1.min(mintotal2).min(mintotal3).min(mintotal4)+" "+ maxtotal1.max(maxtotal2).max(maxtotal3)+"\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
