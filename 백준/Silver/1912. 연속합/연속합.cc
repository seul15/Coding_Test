#include<iostream>
using namespace std;

long long A[100000] = { };
long long dp[100000] = {};
int main() {
	int n;
	cin >> n;

	
	int sum = 0;
	int t;
	for (int i = 0; i < n; i++) {
		cin >> t;
		sum += t;
		A[i] = sum;
	}
	
	long long tmp = 0;
	for (int i = 0; i < n; i++) {
		if (i == 0) dp[0] = A[0];
		else {
			tmp = min(tmp, A[i-1]);
			dp[i] = A[i] - tmp;
		}
	}

	long long ans = 0;
	for (int i = 0; i < n; i++) {
		if (i == 0) ans = dp[0];
		else ans = max(ans, dp[i]);
	}
	cout << ans << "\n";
}