#include<iostream>
#include<cmath>

using namespace std;
int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		pair<int, int> A;
		pair<int, int> B;
		int r_a;
		int r_b;
		cin >> A.first >> A.second >> r_a >> B.first >> B.second >> r_b;

		//A와 B의 거리의 제곱
		long long distance = pow(A.first - B.first, 2) + pow(A.second - B.second, 2);
		// 목표물~A,B 거리 합의 제곱
		long long r = pow(r_a + r_b, 2);
		long long r_m = pow(r_a - r_b, 2);

		if (distance == 0) {
			if (r_a == r_b) cout << "-1" << "\n";
			else cout << "0" << "\n";
		}
		else {
			if (distance < pow(r_a,2) || distance < pow(r_b,2)) {
				if (distance > r_m) cout << "2" << "\n";
				else if (distance == r_m) cout << "1" << "\n";
				else if (distance < r_m) cout << "0" << "\n";
			}
			else {
				if (distance < r) cout << "2" << "\n";
				else if (distance == r ) cout << "1" << "\n";
				else if (distance > r) cout << "0" << "\n";
			}
		}
	}
	return 0;
}