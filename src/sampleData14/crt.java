import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crt {
    static BigInteger getInverse(BigInteger a, BigInteger b) {
        BigInteger[] data = extendedGCD(a, b);
        BigInteger gcd = data[0];
        if (!gcd.equals(BigInteger.ONE)) return null;
        BigInteger x = data[1];
        return x.mod(b).add(b).mod(b);
    }

    static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }

    static BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
        BigInteger r = BigInteger.ZERO, r1 = a, r2 = b;
        BigInteger s = BigInteger.ZERO, s1 = BigInteger.ONE, s2 = BigInteger.ZERO;
        BigInteger t = BigInteger.ZERO, t1 = BigInteger.ZERO, t2 = BigInteger.ONE;
        BigInteger q;
        while (r2.compareTo(BigInteger.ZERO) > 0) {
            q = r1.divide(r2);
            r = r1.subtract(q.multiply(r2));
            r1 = r2;
            r2 = r;

            s = s1.subtract(q.multiply(s2));
            s1 = s2;
            s2 = s;

            t = t1.subtract(q.multiply(t2));
            t1 = t2;
            t2 = t;
        }
        return new BigInteger[]{r1, s1, t1};
    }

    static BigInteger[] crt(ArrayList<BigInteger[]> list) {
        BigInteger[] combinedCongruence = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            BigInteger[] next = list.get(i);
            combinedCongruence = combineCongruence(combinedCongruence[1], combinedCongruence[0], next[1], next[0]);
            if (combinedCongruence == null)
                return null;
        }
        return combinedCongruence;
    }

    static BigInteger[] combineCongruence(BigInteger a1, BigInteger b1, BigInteger a2, BigInteger b2) {
        BigInteger a = a1;
        BigInteger c = a2;
        BigInteger b = b2.subtract(b1).mod(c).add(c).mod(c);
        BigInteger gcd = a.gcd(b).gcd(c);
        a = a.divide(gcd);
        b = b.divide(gcd);
        c = c.divide(gcd);
        if (!a.equals(BigInteger.ONE)) {
            BigInteger inverse = getInverse(a, c);
            if (inverse == null)
                return null;
            b = b.multiply(inverse).mod(c);
        }
        BigInteger x = a1.multiply(b).add(b1);
        BigInteger mod = lcm(a1, a2);
        return new BigInteger[]{x.mod(mod).add(mod).mod(mod), mod};
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("crt.inp");
        File file2 = new File("crt.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ArrayList<BigInteger[]> dataList = new ArrayList<>();
        StringTokenizer st;
        int caseNum = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseNum; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < num; j++) {
                String line = bufferedReader.readLine();
                st = new StringTokenizer(line);
                dataList.add(new BigInteger[]{
                        new BigInteger(st.nextToken()),
                        new BigInteger(st.nextToken())
                });
            }
            BigInteger[] crtResult = crt(dataList);
            if (crtResult == null)
                bufferedWriter.write("-1\n");
            else {
                BigInteger result = crtResult[1].multiply(BigInteger.ZERO).add(crtResult[0]); // Adjusted for clarity
                bufferedWriter.write(result.toString() + "\n");
            }
            dataList.clear();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }

}


