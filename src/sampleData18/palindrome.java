import java.io.*;

public class palindrome {
    static int reverse(int x) {

        int rev = 0;

        while(x>9 || x<-9) {
            rev = rev*10 + x%10;
            x/=10;
        }
        return rev*10+x;
    }
    public static void main(String[] args) throws IOException {
        File file1 = new File("palindrome.inp");
        File file2 = new File("palindrome.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int caseNum = Integer.parseInt(bufferedReader.readLine());
        for(int i =0;i<caseNum;i++){
            int num = Integer.parseInt(bufferedReader.readLine());
            int temp=0;
            boolean isSuccess=false;
            for(int j=0;j<1000;j++){
                temp = reverse(num);
                if(temp == num){
                    isSuccess = true;
                    fileWriter.write(j+"\n");
                    break;
                }else num = Math.abs(num - temp);
            }
            if(!isSuccess)
                fileWriter.write(-1+"\n");

        }
        fileWriter.flush();
        fileWriter.close();
    }
}
