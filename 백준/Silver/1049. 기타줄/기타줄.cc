#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;
	
	int P = 10000; // 세트
	int p = 10000; // 낱개
	
	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		P = min(a, P);
		p = min(b, p);
	}

	cout << min(((int)(N / 6) + 1) * P,min((int)(N/6)*P+N%6*p ,N * p)) << "\n";
}