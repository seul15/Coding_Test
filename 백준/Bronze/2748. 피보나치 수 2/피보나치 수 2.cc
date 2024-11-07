#include<iostream>
using namespace std;

unsigned long long f[100] = {};

unsigned long long fibo(int num) {
	if (num == 1) return 1;
	else if (num == 0) return 0;
	else if (f[num] != 0) return f[num];
	else { 
		f[num] = fibo(num - 1) + fibo(num - 2);
		return f[num];
	}
}

int main() {
	int n;
	cin >> n;
	cout << fibo(n);
	return 0;
}