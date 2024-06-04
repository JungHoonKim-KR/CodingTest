package sampleData6;

import java.io.*;
import java.util.StringTokenizer;


public class rangeSum {
    static class Bit{
        long[] tree;
        Bit(int size){
            tree = new long[size+1];
        }
        void update(long index, long data){
            while(index<tree.length){
                tree[(int) index] += data;
                index += index & -index;
            }
        }
        long sum(long index){
            long sum=0;
            while(index>0){
                sum += tree[(int) index];
                index -= index & -index;
            }
            return sum;
        }
    }
    public static void main(String[] args) throws IOException {
        File file1 = new File("rangeSum.inp");
        File file2 = new File("rangeSum.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer st;

        int num = Integer.parseInt(bufferedReader.readLine());
        Bit bit = new Bit(num);
        long firstIndex, lastIndex;
        String command = null;
        st = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<num;i++){
            long data = Long.parseLong(st.nextToken());
            bit.update(i+1,data);
        }

        while(true) {
            st = new StringTokenizer(bufferedReader.readLine());
            command = st.nextToken();
            if (command.equals("q")) break;

            firstIndex = Integer.parseInt(st.nextToken());
            lastIndex = Long.parseLong(st.nextToken());

            if(command.equals("c")){
                bit.update(firstIndex,lastIndex - (bit.sum(firstIndex) - bit.sum(firstIndex-1)));
            }
            else if(command.equals("s")){
                fileWriter.write(bit.sum(lastIndex) - bit.sum(firstIndex-1)+"\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();

    }
}
