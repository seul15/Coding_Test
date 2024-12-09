#include<iostream>
#include<algorithm>
using namespace std;

int upper[1001];
int lower[1001];
int A[1000];

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];

	fill(upper, upper + 1001, 1);
	fill(lower, lower + 1001, 1);

	// 가장 긴 증가 수열 찾기
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j < i; j++) {
			if (A[j-1] < A[i-1] && upper[i] < upper[j] + 1) upper[i] = upper[j] + 1;
		}
	}

	// 가장 긴 감소 수열 찾기
	for (int i = N; i > 0; i--) {
		for (int j = N; j > i; j--) {
			if (A[j-1] < A[i-1] && lower[i] < lower[j] + 1) lower[i] = lower[j] + 1;
		}
	}

	int ans = 0;
	for (int i = 1; i <= N; i++) ans = max(ans, upper[i] + lower[i] - 1);

	cout << ans << "\n";
}