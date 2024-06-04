import java.io.*;
import java.util.StringTokenizer;

public class jolly {
    public static void main(String[] args) throws IOException {
        File file1 = new File("jolly.inp");
        File file2 = new File("jolly.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer st;
        String line;
        while((line = bufferedReader.readLine())!=null){
            boolean isBreak = false;
            st = new StringTokenizer(line);
            int num = Integer.parseInt(st.nextToken());
            boolean checkArr[] = new boolean[num+1];
            int first = Integer.parseInt(st.nextToken());
            for(int i =2; i<=num;i++){
                int second = Integer.parseInt(st.nextToken());
                int findDiff = Math.abs(second - first);
                if(findDiff >= num || checkArr[findDiff] == true){
                    fileWriter.write("Not Jolly\n");
                    isBreak = true;
                    break;
                }
                else{
                    checkArr[findDiff] = true;
                    first = second;
                }
            }
            if(!isBreak)
                fileWriter.write("Jolly\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
