import java.io.*;
import java.util.*;
import java.math.BigInteger;

class ContourPoint implements Comparable<ContourPoint>{
    int x, y;
    boolean isStart;

    @Override
    public int compareTo(ContourPoint o) {
        if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        } else {
            if (this.isStart && !o.isStart) {
                return -1;
            } else if (!this.isStart && o.isStart) {
                return 1;
            } else {
                if (this.isStart) {
                    return Integer.compare(o.y, this.y);
                } else {
                    return Integer.compare(this.y, o.y);
                }
            }
        }
    }

    ContourPoint(int x, int y, boolean isStart){
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }
}

public class contour {
    public static void main(String[] args) throws IOException {
        File file1 = new File("contour.inp");
        File file2 = new File("contour.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line;
        List<ContourPoint> data = new ArrayList<>();
        int caseNum = 0;
        boolean isEnd = false;
        while(true) {
            while(true) {
                line = bufferedReader.readLine();
                if (line == null || line.isEmpty()) {
                    isEnd = true;
                    break;
                } else if (line.trim().equals("0 0 0")) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(line);
                int start = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                data.add(new ContourPoint(start, height, true));
                data.add(new ContourPoint(end, height, false));
            }
            if(isEnd)
                break;
            bufferedReader.readLine();
            int prevX = 0;
            int prevMaxHeight = 0;
            BigInteger totalArea = BigInteger.ZERO;
            Collections.sort(data);
            Queue<BigInteger> resultQueue = new LinkedList<>();
            TreeMap<Integer, Integer> heightTree = new TreeMap<>((o1, o2) -> o2 - o1);
            for (ContourPoint p : data) {
                if(prevX == 0 && prevMaxHeight == 0)
                    prevX = p.x;
                if (p.isStart)
                    heightTree.put(p.y, heightTree.getOrDefault(p.y, 0) + 1);
                else {
                    if (heightTree.get(p.y) == 1)
                        heightTree.remove(p.y);
                    else
                        heightTree.put(p.y, heightTree.get(p.y) - 1);
                }
                int curMaxHeight = heightTree.isEmpty() ? 0 : heightTree.firstKey();
                if (prevMaxHeight != curMaxHeight) {
                    BigInteger area = BigInteger.valueOf(p.x - prevX).multiply(BigInteger.valueOf(prevMaxHeight));
                    totalArea = totalArea.add(area);
                    prevX = p.x;
                    prevMaxHeight = curMaxHeight;
                    if(curMaxHeight == 0) {
                        resultQueue.add(totalArea);
                        totalArea = BigInteger.ZERO;
                        prevX = 0;
                    }
                }
            }
            StringBuilder resultBuilder = new StringBuilder();
            while (!resultQueue.isEmpty()) {
                resultBuilder.append(resultQueue.poll().toString());
                if (!resultQueue.isEmpty()) {
                    resultBuilder.append(" ");
                }
            }
            caseNum++;
            bufferedWriter.write("Test Case #" + caseNum + " : " + resultBuilder + "\n");
            data.clear();
            resultQueue.clear();
            heightTree.clear();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
