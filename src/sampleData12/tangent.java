import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class tangent{
    private static int indexOfLowestPoint(Point[] points) {
        int index = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < points[index].y ||
                    (points[i].y == points[index].y && points[i].x < points[index].x)) {
                index = i;
            }
        }
        return index;
    }

    private static double crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }
    private static double calculateAngle(Point origin, Point target) {
        double dx = target.x - origin.x;
        double dy = target.y - origin.y;
        return Math.atan2(dy, dx); // 라디안 값으로 각도 반환
    }
    private static double calculateAngleBetweenVectors(Point a, Point b, Point c) {
        double angleAB = calculateAngle(a, b);
        double angleBC = calculateAngle(b, c);
        double angleDifference = Math.toDegrees(angleBC - angleAB);

        // 각도 정규화
        if (angleDifference < 0) {
            angleDifference += 360;
        }
        else if(angleDifference>360)
            angleDifference-=360;

        return angleDifference;
    }
    public static void findTangents(Point[][] hulls, List<Point[]> tangents) {
        Point[] hull1 = hulls[0];
        Point[] hull2 = hulls[1];
        int n = hull1.length;
        int m = hull2.length;
        double value;

        int i = indexOfLowestPoint(hull1);
        int j = indexOfLowestPoint(hull2);
        boolean done = false;
        int bestI=i;
        int resultI = 0,resultJ =0;

        double curValue =Float.MIN_VALUE;
        for(int k=0;k<n;k++){
            if((crossProduct(hull2[j], hull1[i], hull1[(i + 1) % n])) >= 0){
                value = calculateAngleBetweenVectors(hull2[j], hull1[i], hull1[(i + 1) % n]);
               if(value>curValue){
                   curValue = value;
                   resultI = i;
                }
            }
            i = (i + 1) % n;

        }
        i = bestI;
        curValue = Float.MIN_VALUE;
        for(int k=0;k<m;k++){
            if(crossProduct(hull1[i], hull2[j], hull2[(j + 1) % m]) >= 0){
                if((value =calculateAngle(hull2[j],hull1[i]))>curValue){
                    curValue = value;
                    resultJ = j;
                }
            }
            j = (j + 1) % m;
        }
        tangents.add(new Point[]{hull1[resultI], hull2[resultJ]});

        i = indexOfLowestPoint(hull1);
        j = indexOfLowestPoint(hull2);
        bestI = i;
        done = false;
        while (!done) {
            done = true;
            while (crossProduct(hull2[j], hull1[i], hull1[(i - 1 + n) % n]) >= 0) {
                i = (i - 1 + n) % n;
            }
            resultI = i;
            i= bestI;
            while (crossProduct(hull1[i], hull2[j], hull2[(j - 1 + m) % m]) <= 0) {
                j = (j - 1 + m) % m;
                done = false;
            }
        }
        tangents.add(new Point[]{hull1[resultI], hull2[j]});
    }
    private static int findIndex(Point[] array, Point point) {
        for (int i = 0; i < array.length; i++) {
            if (point.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static List<Point> formClosureArea(Point[] poly1, Point[] poly2, Point[] tangent1, Point[] tangent2) {
        List<Point> closureArea = new ArrayList<>();

        int startIndex1 = findIndex(poly1, tangent1[0]);
        int endIndex1 = findIndex(poly1, tangent2[1]);
        int startIndex2 = findIndex(poly2, tangent1[1]);
        int endIndex2 = findIndex(poly2, tangent2[0]);

        int i = startIndex1;
        do {
            closureArea.add(poly1[i]);
            i = (i + 1) % poly1.length;
        } while (i != (endIndex1 + 1) % poly1.length);

        closureArea.add(tangent1[1]);

        int j = startIndex2;
        do {
            closureArea.add(poly2[j]);
            j = (j + 1) % poly2.length;
        } while (j != (endIndex2 + 1) % poly2.length);

        closureArea.add(tangent2[1]);

        return closureArea;
    }
    public static double calculatePolygonArea(List<Point> points) {
        double area = 0.0;
        int n = points.size();
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += p1.x * p2.y - p2.x * p1.y;
        }
        return Math.abs(area / 2.0);
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("sampleData12/tangent.inp");
        File file2 = new File("tangent.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int caseNum = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<caseNum;i++){
            List<Point[]> tangents = new ArrayList<>();
            Point[][] points = new Point[2][];
            for(int j=0;j<2;j++){
                int num = Integer.parseInt(bufferedReader.readLine());
                points[j] = new Point[num];
                for(int k = 0;k<num;k++){
                    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                    points[j][k]= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                }
            }
            findTangents(points,tangents);
            for(Point [] t: tangents){
                System.out.println("x:" + t[0].x+" y:"+t[0].y);
                System.out.println("x:" + t[1].x+" y:"+t[1].y);

            }
            List<Point> closureAreaPoints = formClosureArea(points[0], points[1], tangents.get(0), tangents.get(1));
            double result = calculatePolygonArea(closureAreaPoints);
            bufferedWriter.write(result+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}