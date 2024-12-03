#include<iostream>
#include<algorithm>
using namespace std;

int A[500][500];
int dp[500][500] = {};

int main() {
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) cin >> A[i][j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			if (i == 0 && j == 0) dp[0][0] = A[0][0];
			if (j == 0) dp[i][j] = A[i][j] + dp[i - 1][j];
			else if (j == i) dp[i][j] = A[i][j] + dp[i - 1][j - 1];
			else dp[i][j] = A[i][j] + max(dp[i-1][j-1],dp[i-1][j]);
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++) ans = max(ans, dp[n - 1][i]);
	cout << ans << "\n";
}