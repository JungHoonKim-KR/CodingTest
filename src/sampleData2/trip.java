import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class trip {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("sampleData2/1.inp");
        FileWriter fileWriter = new FileWriter("trip.out");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int num;
        float totalMoney, avgMoney, resultMinMoney, resultMaxMoney;

        while (0 != (num = Integer.parseInt(bufferedReader.readLine()))) {
            totalMoney=0; resultMinMoney=0;resultMaxMoney=0;
            ArrayList<Float> money = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                money.add(Float.valueOf(bufferedReader.readLine()));
                totalMoney += money.get(i);
            }
            money.sort(Comparator.naturalOrder());
            avgMoney = totalMoney / num;

            for(Float m : money){
                if(m<avgMoney)
                    resultMinMoney += Math.floor((avgMoney - m)*100)/100;
                else resultMaxMoney+= Math.floor((m - avgMoney)*100)/100;
            }

            fileWriter.write("$"+Math.max(resultMinMoney,resultMaxMoney)+"\n");

        }

        fileWriter.flush();
        fileWriter.close();
    }
}

