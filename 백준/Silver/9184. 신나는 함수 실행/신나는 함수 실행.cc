#include<iostream>
#include<algorithm>
using namespace std;
int dp[21][21][21] = {};

int func(int a, int b, int c) {
	if (a <= 0 || b <= 0 || c <= 0) return 1;
	else if (a > 20 || b > 20 || c > 20)  return func(20, 20, 20);
	else if (dp[a][b][c] != -1) return dp[a][b][c];
	else if (a < b && b < c) {
		int result = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);
		dp[a][b][c] = result;
		return result;
	}
	else {
		int result = func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
		dp[a][b][c] = result;
		return result;
	}
}

int main() {
	for (int i = 0; i < 21; i++) {
		for (int j = 0; j < 21; j++) {
			fill(dp[i][j], dp[i][j] + 21, -1);
		}
	}

	int a, b, c;
	while (1) {
		cin >> a >> b >> c;
		if (a == -1 && b == -1 && c == -1) break;
		else cout << "w(" << a << ", " << b << ", " << c << ") = " << func(a, b, c) << "\n";
	}
}