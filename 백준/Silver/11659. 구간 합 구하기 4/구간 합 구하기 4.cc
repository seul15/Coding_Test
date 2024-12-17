#include<iostream>
using namespace std;

int A[100000];
long long sum[100000] = {};

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M;
	cin >> N >> M;

	for (int i = 0; i < N; i++) { 
		cin >> A[i]; 
		if (i == 0) sum[0] = A[0];
		else sum[i] = sum[i - 1] + A[i];
	}
	for (int i = 0; i < M; i++) {
		int s, e;
		cin >> s >> e;
		if (s == 1) cout << sum[e-1] << "\n";
		else cout << sum[e-1] - sum[s - 2] << "\n";
	}
}