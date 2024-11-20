#include<iostream>

using namespace std;

int main() {
	int N, S, M;
	cin >> N >> S >> M;
	int vol[50] = {0,};
	bool dp[50][1001] = { false, };

	for (int i = 0; i < N; i++) cin >> vol[i];

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= M; j++) {
			if (i == 0) {
				if (S + vol[i] <= M) dp[i][S + vol[i]] = true;
				if (S - vol[i] >= 0) dp[i][S - vol[i]] = true;
			}
			else if (i != 0 && dp[i - 1][j] == true) {
				if (j + vol[i] <= M) dp[i][j + vol[i]] = true;
				if (j - vol[i] >= 0) dp[i][j - vol[i]] = true;
			}
		}
	}

	int ans = -1;
	for (int i = M; i >=0; i--) {
		if (dp[N - 1][i] == true) { 
			ans = i; 
			break;
		}
	}
	cout << ans << "\n";
	return 0;
}