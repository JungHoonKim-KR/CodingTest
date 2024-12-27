import java.io.*;
import java.util.*;
import java.util.List;

class Point implements  Comparable<Point> {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o1) {
        if(this.x != o1.x)
            return this.x - o1.x;
        else return this.y - o1.y;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        StringTokenizer st;
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i).x+" "+list.get(i).y);
            bw.newLine();
        }
        bw.flush();
    }
}


