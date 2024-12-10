#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	vector<int>A;
	vector<int>B;
	int N;
	cin >> N;

	int tmp;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		A.push_back(tmp);
	}
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		B.push_back(tmp);
	}

	sort(A.begin(), A.end(), greater<int>());
	sort(B.begin(), B.end(), less<int>());

	int ans = 0;
	for (int i = 0; i < N; i++) ans += A[i] * B[i];

	cout << ans << "\n";
}