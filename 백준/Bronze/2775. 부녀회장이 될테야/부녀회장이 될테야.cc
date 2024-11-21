#include<iostream>
using namespace std;

int dp[15][15] = {};

int count(int k, int n) {
	if (n == 1 && k == 1) return 1;
	if (dp[k][n] != 0) return dp[k][n];
	if (k == 1) return count(k,n-1) + n;
	if (n == 1) return count(k-1,n);

	int result = count(k, n - 1) + count(k - 1, n);
	dp[k][n] = result;
	return result;
}

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int k, n;
		cin >> k >> n;
		cout << count(k, n) << "\n";
	}
}