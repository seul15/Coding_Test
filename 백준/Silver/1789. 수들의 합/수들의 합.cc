#include<iostream>
using namespace std;

int main() {
	long long S;
	cin >> S;
	long long N=0;
	while (S > N) {
		N++;
		S -= N;
	}

	cout << N << "\n";
}