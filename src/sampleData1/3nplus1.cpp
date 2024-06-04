#include <iostream>
#include <fstream>
#include <map>
#include <algorithm>
#include <string>

using namespace std;

map<long long, int> dp;

int fun(long long n) {
    if (n == 1) return 1;
    if (dp.find(n) != dp.end()) return dp[n];
    int value;
    if (n % 2 == 1) value = fun(3 * n + 1) + 1;
    else value = fun(n / 2) + 1;
    dp[n] = value;
    return value;
}

int main() {
    ifstream fileReader("3nplus1.inp");
    ofstream fileWriter("3nplus1.out");
    int tempStart, tempEnd;
    while (fileReader >> tempStart >> tempEnd) {
        int start = min(tempStart, tempEnd);
        int end = max(tempStart, tempEnd);
        int result = 0, tempResult;
        for (long long i = start; i <= end; i++) {
            tempResult = fun(i);
            if (result < tempResult)
                result = tempResult;
        }
        fileWriter << tempStart << " " << tempEnd << " " << result << "\n";
        cout << result << ;
    }
    fileWriter.close();
    return 0;
}
