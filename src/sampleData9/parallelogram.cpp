#include<iostream>
#include<fstream>
#include<vector>
#include <algorithm>
using namespace std;

struct Point {
	int x, y;
	static Point startPoint;

	static double calTan2(const Point& p1, const Point& p2) {
		return atan2(p1.y - p2.y, p1.x - p2.x);
	}

	static bool isParallel(const Point& p1, const Point& p2, const Point& p3, const Point& p4) {
		int dx1 = p1.x - p2.x;
		int dy1 = p1.y - p2.y;
		int dx2 = p3.x - p4.x;
		int dy2 = p3.y - p4.y;
		int crossProduct = dx1 * dy2 - dy1 * dx2;
		return crossProduct == 0;
	}


	static double dist(const Point& p1) {
		return (static_cast<double>(startPoint.x) - p1.x) * (static_cast<double>(startPoint.x) - p1.x)
			+ (static_cast<double>(startPoint.y) - p1.y) * (static_cast<double>(startPoint.y) - p1.y);
	
	}
	static int distJudge(double d1, double d2) {
		if (d1 < d2) return -1;
		else return 1;
	}
	static int compare(const Point& p1, const Point& p2) {
		double angle1 = calTan2(startPoint, p1);
		double angle2 = calTan2(startPoint, p2);
		if (angle1 < angle2) return -1;
		else if (angle1 > angle2) return 1;
		else return distJudge(dist(p1),dist(p2));
	}
};

int selectStartPoint(const vector<Point>& arr) {
	int index=0; 
	int y = arr[0].y;
	for (int i = 1; i < 4; ++i) {
		if (y > arr[i].y) {
			index = i;
			y = arr[i].y;
		}
	}
	return index;


};
Point Point::startPoint;
int main() {

	ifstream file1("parallelogram.inp");
	ofstream file2("parallelogram.out");
	vector<Point> points(4);
	double angle[4];
	double dist[4];
	while (file1 >> points[0].x >> points[0].y >> points[1].x >> points[1].y
		>> points[2].x >> points[2].y >> points[3].x >> points[3].y) {
		if (points[0].x == 0 && points[0].y == 0 && points[1].x == 0 && points[1].y == 0
			&& points[2].x == 0 && points[2].y == 0 && points[3].x == 0 && points[3].y == 0)
			break;

		int minIndex = selectStartPoint(points);
		swap(points[minIndex], points[0]);

		Point::startPoint = points[0];

		sort(points.begin() + 1, points.end(), [](const Point& p1, const Point& p2) {
			return Point::compare(p1, p2) < 0;
			});
		
		
		for(int i =0;i<4;i++){
			if (i == 3) {
				dist[i] = (static_cast<double>(points[i].x) - points[0].x) * (static_cast<double>(points[i].x) - points[0].x)
					+ (static_cast<double>(points[i].y) - points[0].y) * (static_cast<double>(points[i].y) - points[0].y);
			}
			else {
				dist[i] = (static_cast<double>(points[i].x) - points[i+1].x) * (static_cast<double>(points[i].x) - points[i+1].x)
					+ (static_cast<double>(points[i].y) - points[i+1].y) * (static_cast<double>(points[i].y) - points[i+1].y);
			}

		}

		if (dist[0] == dist[2] && dist[1] == dist[3] && Point::isParallel(points[0], points[1], points[2], points[3]) && Point::isParallel(points[1], points[2], points[0], points[3]))
			file2 << 1 << "\n";
		else file2 << 0 << "\n";


	}

}