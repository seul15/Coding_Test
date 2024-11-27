#include<iostream>
using namespace std;

long long glass[10000] = {};
long long dp[10000] = {};
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> glass[i];

	for (int i = 0; i < n; i++) {
		if (i == 0) dp[0] = glass[0];
		else if (i == 1) dp[1] = glass[0] + glass[1];
		else if (i == 2) dp[2] = max(dp[1],glass[2]+max(glass[0],glass[1]));
		// 현재,이전꺼 안 먹는 경우, 현재꺼만 먹는 경우, 현재, 이전꺼 둘 다 먹는 경우 중 최댓값
		else dp[i] = max(dp[i-1],max(glass[i]+dp[i-2],glass[i]+glass[i-1]+dp[i-3]));
	}
	cout <<dp[n-1]<< "\n";
}