#include<iostream>
#include<algorithm>
using namespace std;

long long dp[1000] = {};

int main() {
	int N;
	cin >> N;

	int A[1000] = {};
	for (int i = 0; i < N; i++) cin >> A[i];

	long long ans = 0;
	for (int i = 0; i < N; i++) {
		if (i == 0) dp[i] = A[i];
		else {
			long long temp=A[i];
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] > A[j]) temp = max(temp, dp[j] + A[i]);
			}
			dp[i] = temp;
		}
		ans = max(ans, dp[i]);
	}

	cout << ans << "\n";
}