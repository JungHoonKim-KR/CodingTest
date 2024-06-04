import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class areaPoint {
    double x, y;
    areaPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class Circle {
    int r;
    areaPoint p;
    Circle(areaPoint p, int r) {
        this.p = new areaPoint(p.x, p.y);
        this.r = r;
    }
}

public class area {
    static List<areaPoint> findIntersection(Circle c1, Circle c2) {
        areaPoint p1 = c1.p;
        areaPoint p2 = c2.p;
        double centerDist = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        double a = 2 * (p2.x - p1.x);
        double b = 2 * (p2.y - p1.y);
        double c = (Math.pow(p1.x, 2) - Math.pow(p2.x, 2)) + (Math.pow(p1.y, 2) - Math.pow(p2.y, 2)) + (Math.pow(c2.r, 2) - Math.pow(c1.r, 2));
        double k = (a * p1.x + b * p1.y + c) / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double h = Math.sqrt(Math.pow(c1.r, 2) - Math.pow(k, 2));

        double crossX = p1.x + (p1.x - p2.x) * k / centerDist;
        double crossY = p1.y + (p1.y - p2.y) * k / centerDist;

        double intersectionX1 = crossX + (p2.y - p1.y) * h / centerDist;
        double intersectionY1 = crossY - (p2.x - p1.x) * h / centerDist;
        double intersectionX2 = crossX - (p2.y - p1.y) * h / centerDist;
        double intersectionY2 = crossY + (p2.x - p1.x) * h / centerDist;

        ArrayList<areaPoint> list = new ArrayList<>();
        list.add(new areaPoint(intersectionX1, intersectionY1));
        list.add(new areaPoint(intersectionX2, intersectionY2));
        return list;
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("area.inp");
        File file2 = new File("area.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Circle[] circles = new Circle[3];
        areaPoint[] intersections = new areaPoint[6];
        areaPoint[] result = new areaPoint[3];
        int num = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                areaPoint point = new areaPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                circles[j] = new Circle(point, Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < 3; j++) {
                List<areaPoint> intersection = findIntersection(circles[j % 3], circles[(j + 1) % 3]);
                intersections[j * 2] = intersection.get(0);
                intersections[j * 2 + 1] = intersection.get(1);
            }
            int k = 0;
            for (areaPoint p : intersections) {
                boolean isIntersect = true;
                for (Circle c : circles) {
                    double sqrt = Math.sqrt(Math.pow(p.x - c.p.x, 2) + Math.pow(p.y - c.p.y, 2));
                    if (c.r < Math.floor(sqrt)) {
                        isIntersect = false;
                        break;
                    }
                }
                if (isIntersect) {
                    result[k] = p;
                    k++;
                    if (k == 3) break;
                }
            }
            double area =Math.abs(result[0].x * (result[1].y - result[2].y) + result[1].x * (result[2].y - result[0].y) + result[2].x * (result[0].y - result[1].y))
                    / 2.0;


            String format = String.format("%.2f", area);
            fileWriter.write(format+"\n");
            if (i != num - 1)
                bufferedReader.readLine();

        }
        fileWriter.flush();
        fileWriter.close();

    }
}
