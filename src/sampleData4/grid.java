//import java.io.*;
//import java.util.StringTokenizer;
//
//class Point {
//    int valueArr[], judge;
//    Point(int arrSize, int judge) {
//        this.valueArr = new int[arrSize + 1];
//        this.judge = judge;
//    }
//    void normalShifting() {
//        int size = valueArr.length;
//        if(size>=2) {
//            valueArr[size - 1] = (valueArr[size - 1] % 1000000007 + valueArr[size - 2] % 1000000007)%1000000007;
//            for (int k = size - 2; k > 0; k--) {
//                valueArr[k] = valueArr[k - 1];
//            }
//            valueArr[0] = 0;
//        }
//    }
//    void addShifting(int[] arr1, int[] arr2) {
//        add(arr1,arr2);
//        normalShifting();
//    }
//    void add(int[] arr1, int[] arr2) {
//        for (int n = 0; n < valueArr.length; n++) {
//            valueArr[n] = (arr1[n]%1000000007 + arr2[n]%1000000007)%1000000007;
//        }
//    }
//    void copyArr(int[] arr2) {
//        for (int l = 0; l < valueArr.length; l++) {
//            valueArr[l] = arr2[l];
//        }
//    }
//
//}
//
//public class grid {
//    public static void main(String[] args) throws IOException {
//        File file1 = new File("grid.inp");
//        File file2 = new File("grid.out");
//        FileReader fileReader = new FileReader(file1);
//        FileWriter fileWriter = new FileWriter(file2);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringTokenizer st;
//        String line;
//        int num = Integer.parseInt(bufferedReader.readLine());
//        int x, y, ban, must, k;
//        for (int i = 0; i < num; i++) {
//            line = bufferedReader.readLine();
//            st = new StringTokenizer(line);
//            x = Integer.parseInt(st.nextToken());
//            y = Integer.parseInt(st.nextToken());
//            must = Integer.parseInt(st.nextToken());
//            ban = Integer.parseInt(st.nextToken());
//            k = Integer.parseInt(st.nextToken());
//            Point arr[][] = new Point[x + 1][y + 1];
//            for (int l = 0; l < x + 1; l++) {
//                for (int m = 0; m < y + 1; m++) {
//                    arr[l][m] = new Point(k, 1);
//                }
//            }
//            if(must>0){
//                line = bufferedReader.readLine();
//                st = new StringTokenizer(line);
//            }
//            for (int j = 0; j < must; j++) {
//                int xPoint = Integer.parseInt(st.nextToken());
//                int yPoint = Integer.parseInt(st.nextToken());
//                arr[xPoint][yPoint].judge = 2;
//            }
//            if(ban>0){
//                line = bufferedReader.readLine();
//                st = new StringTokenizer(line);
//            }
//            for (int j = 0; j < ban; j++) {
//                int xPoint = Integer.parseInt(st.nextToken());
//                int yPoint = Integer.parseInt(st.nextToken());
//                arr[xPoint][yPoint].judge = 0;
//            }
//            arr[0][0].valueArr[0] = 1;
//            for (int n = 1; n < x + 1; n++) {
//                int judge = arr[n][0].judge;
//                if (judge == 0)
//                    break;
//                arr[n][0].copyArr(arr[n - 1][0].valueArr);
//                if (judge == 2){
//                    arr[n][0].normalShifting();
//                }
//            }
//            for (int n = 1; n < y + 1; n++) {
//                int judge = arr[0][n].judge;
//                if (judge == 0)
//                    break;
//                arr[0][n].copyArr(arr[0][n - 1].valueArr);
//                if (judge == 2){
//                    arr[0][n].normalShifting();
//                }
//            }
//            for (int xPoint = 1; xPoint < x + 1; xPoint++) {
//                for (int yPoint = 1; yPoint < y + 1; yPoint++) {
//                    int judge = arr[xPoint][yPoint].judge;
//                    if (judge == 1)
//                        arr[xPoint][yPoint].add(arr[xPoint - 1][yPoint].valueArr, arr[xPoint][yPoint - 1].valueArr);
//                    else if (judge == 2)
//                        arr[xPoint][yPoint].addShifting(arr[xPoint - 1][yPoint].valueArr, arr[xPoint][yPoint - 1].valueArr);
//                }
//            }
//            if(i != num-1)
//                fileWriter.write(arr[x][y].valueArr[k]+"\n");
//            else
//                fileWriter.write(arr[x][y].valueArr[k]+"");
//        }
//        fileWriter.flush();
//        fileWriter.close();
//    }
//}