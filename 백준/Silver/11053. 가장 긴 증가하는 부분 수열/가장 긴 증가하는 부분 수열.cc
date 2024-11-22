#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	int A[1000];
	for (int i = 0; i < N; i++) cin >> A[i];

	int dp[1000];
	fill(dp, dp + 1000, 1);
	for (int i = 1; i < N; i++) {
		int tmp =1;
		for (int j = i - 1; j >= 0; j--) {
			if (A[i] > A[j]) tmp = max(tmp, dp[j] + 1);
		}
		dp[i] = tmp;
	}
	int ans = dp[0];
	for (int i = 1; i < N; i++) {
		ans = max(dp[i], ans);
	}
	cout << ans << "\n";
}