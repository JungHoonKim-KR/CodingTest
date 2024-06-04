//import java.io.*;
//import java.util.*;
//
//class Point implements Comparable<Point>{
//    int x, y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//    static Point startPoint;
//
//    static double calAngle(Point a, Point b) {
//        return Math.atan2((b.y - a.y), (b.x - a.x));
//    }
//    static int dist(Point a, Point b){
//        double dist1 = (startPoint.x - a.x) * (startPoint.x - a.x) + (startPoint.y - a.y) * (startPoint.y - a.y);
//        double dist2 = (startPoint.x - b.x) * (startPoint.x - b.x) + (startPoint.y - b.y) * (startPoint.y - b.y);
//        if (dist1 < dist2) return -1;
//        else return 1;
//    }
//    @Override
//    public int compareTo(Point o) {
//        double angle1 = calAngle(startPoint, this);
//        double angle2 = calAngle(startPoint, o);
//        if (angle1 < angle2) return -1;
//        else if (angle1 > angle2) return 1;
//        else return dist(this,o);
//    }
//}
//class ConvexHull{
//    static Stack<Point> stack = new Stack<>();
//    static private int ccw(Point a, Point b, Point c){
//        int result = (a.x * b.y + b.x*c.y+ c.x*a.y) - (b.y * c.x + a.x * c.y + a.y*b.x);
//        if(result>0) return 1;
//        else if(result<0) return -1;
//        else return 0;
//    }
//    static Stack<Point> graham(Point [] points){
//        stack.push(Point.startPoint);
//        stack.push(points[1]);
//        for(int i =2 ; i<points.length;i++){
//            Point three = points[i];
//            Point two = stack.pop();
//            Point one = stack.peek();
//            while(!stack.empty() && !leftTurn(one,two,three)){
//                two = stack.pop();
//                if(!stack.empty())
//                    one = stack.peek();
//            }
//            stack.push(two);
//            stack.push(three);
//        }
//        return stack;
//    }
//    static private boolean leftTurn(Point a, Point b, Point c){
//        return ccw(a,b,c)>0;
//    }
//}
//public class hull {
//    public static void main(String[] args) throws IOException {
//        File file1 = new File("hull.inp");
//        File file2 = new File("hull.out");
//        FileReader fileReader = new FileReader(file1);
//        FileWriter fileWriter = new FileWriter(file2);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        StringTokenizer st;
//
//        String line;
//        int num = Integer.parseInt(bufferedReader.readLine());
//        Point arr[]= new Point[num];
//        int minX = 1000000;
//        int minY = 1000000;
//        int minIndex = -1;
//        for(int i=0; i<num; i++){
//            line = bufferedReader.readLine();
//            st = new StringTokenizer(line);
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            arr[i] = new Point(x,y);
//            if(minX> x){
//                minX = x;
//                minY = y;
//                minIndex = i;
//            }
//            else if(minX == x){
//                if(minY > y){
//                    minX = x;
//                    minY = y;
//                    minIndex = i;
//                }
//            }
//
//        }
//
//        Point temp = arr[minIndex];
//        arr[minIndex] = arr[0];
//        arr[0] = temp;
//
//        Point.startPoint = arr[0];
//        Arrays.sort(arr,1,num);
//        Stack<Point> graham = ConvexHull.graham(arr);
//        ArrayList<Point> resultList = new ArrayList<>();
//
//        while(!graham.empty()){
//            resultList.add(graham.pop());
//        }
//        fileWriter.write(resultList.size()+"\n");
//
//        for(int i = resultList.size()-1; i>=0;i--){
//            Point point = resultList.get(i);
//            fileWriter.write(point.x + " "+ point.y+"\n");
//        }
//        fileWriter.flush();
//        fileWriter.close();
//    }
//
//}
