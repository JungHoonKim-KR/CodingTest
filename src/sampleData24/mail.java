import java.io.*;

public class mail {
    public static void main(String[] args) throws IOException {
        File file1 = new File("mail.inp");
        File file2 = new File("mail.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String arr[] = new String[8];
        String alphabet[] = {"A","B","C","D","E","F","G","H","X"};
        arr[0] = "000000";
        arr[1] = "001111";
        arr[2] = "010011";
        arr[3] = "011100";
        arr[4] = "100110";
        arr[5] = "101001";
        arr[6] = "110101";
        arr[7] = "111010";
        int caseNum = Integer.parseInt(bufferedReader.readLine());
        for(int c=0; c< caseNum;c++){
            int num = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine();
            String result = "";
            for(int i =0;i<num;i++){
                int j=0;
                for(;j<8;j++){
                    int count=0;
                    for(int k=0;k<6;k++){
                        if(s.charAt(i * 6 + k) != arr[j].charAt(k)){
                            count++;
                            if(count >2) break;
                        }
                    }
                    if(count<2)
                        break;
                }
                result+=alphabet[j];
            }
            fileWriter.write(result+"\n");
        }
        fileWriter.flush();
        fileWriter.close();

    }
}
