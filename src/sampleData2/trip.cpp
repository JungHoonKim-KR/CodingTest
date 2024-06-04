#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <iomanip>

using namespace std;
int main() {
    const string inputFile = "trip.inp";
    const string outputFile = "trip.out";
    const double precision = 100.0; // 정밀도를 상수로 정의

    ifstream bufferedReader(inputFile);
    ofstream fileWriter(outputFile);

    if (!bufferedReader.is_open() || !fileWriter.is_open()) {
        cerr << "파일을 열 수 없습니다." << endl;
        return -1;
    }

    int num;
    double totalMoney, avgMoney, resultMinMoney, resultMaxMoney;

    while (bufferedReader >> num && num != 0) {
        totalMoney = 0;
        resultMinMoney = 0;
        resultMaxMoney = 0;
        vector<double> money;

        for (int i = 0; i < num; i++) {
            double temp;
            bufferedReader >> temp;
            money.push_back(temp);
            totalMoney += temp;
        }
        sort(money.begin(), money.end());
        avgMoney = totalMoney / num;

        for (double m : money) {
            if (m < avgMoney)
                resultMinMoney += floor((avgMoney - m) *100)/100;
            else
                resultMaxMoney += floor((m - avgMoney) *100)/100;
        }

        fileWriter << "$" << fixed << setprecision(2) << max(resultMinMoney, resultMaxMoney) << "\n";
    }

    return 0;
}
