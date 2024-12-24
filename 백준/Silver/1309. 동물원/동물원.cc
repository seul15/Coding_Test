#include<iostream>
using namespace std;
int dp[100000][3] = {}; //0 은 왼쪽만 채워진 경우, 1은 오른쪽만 채워진 경우, 2는 둘 다 비어있는 경우

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			if (i == 0) dp[i][j] = 1;
			else {
				if (j == 0) dp[i][j] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
				else if (j == 1) dp[i][j] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
				else if (j == 2) dp[i][j] = (dp[i - 1][0] + dp[i - 1][1] +dp[i-1][2]) % 9901;
			}	
		}
	}

	cout << (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2])%9901 << "\n";
}