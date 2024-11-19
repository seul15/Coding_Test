#include<iostream>
using namespace std;

int money[1000][3] = { 0, };
int dp[1000][3] = { 0, };

int main() {
	int N;
	cin >> N;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) cin >> money[i][j];
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j< 3; j++) {
			if (i == 0) dp[i][j] = money[i][j];
			else {
				dp[i][j] = money[i][j] + min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}
	}

	cout << min(min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]) << "\n";

	return 0;
}