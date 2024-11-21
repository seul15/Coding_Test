#include<iostream>
using namespace std;

int main() {
	int test_case;
	cin >> test_case;
	int dp[12] = { };
	for (int i = 0; i < test_case; i++) {
		int n;
		cin >> n;
		for (int j = 1; j <= n; j++) {
			if (dp[j] == 0) {
				if (j == 1) dp[j] = 1;
				else if (j == 2) dp[j] = 1 + dp[j - 1];
				else if (j == 3) dp[j] = 1 + dp[j - 1] + dp[j - 2];
				else dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			else continue;
		}
		cout << dp[n] << "\n";
	}
}