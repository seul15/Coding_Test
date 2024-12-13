#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;

int dp[100001] = {};

int main() {
	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		if (sqrt(i) == (int)sqrt(i)) dp[i] = 1;
		else {
			int temp = (int)sqrt(i);
			int max_e = dp[(int)pow(temp,2)] + dp[i - (int)pow(temp, 2)];
			while (temp> 0) {
				max_e = min(max_e, dp[(int)pow(temp, 2)] + dp[i - (int)pow(temp, 2)]);
				temp--;
			}
			dp[i] = max_e;
		}
	}

	cout << dp[N] << "\n";
}