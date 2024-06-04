import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class add {
    public static void main(String[] args) throws IOException {
        File file1 = new File("add.inp");
        File file2 = new File("add.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null && !line.equals("0")) {
            int num = Integer.parseInt(line);
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            PriorityQueue<BigInteger> queue = new PriorityQueue<>();

            for (int i = 0; i < num; i++) {
                queue.add(new BigInteger(st.nextToken()));
            }

            BigInteger result = BigInteger.ZERO;
            while (queue.size() > 1) {
                BigInteger first = queue.poll();
                BigInteger second = queue.poll();
                BigInteger sum = first.add(second);
                result = result.add(sum);
                queue.add(sum);
            }
            fileWriter.write(result.toString() + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
