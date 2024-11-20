#include<iostream>
using namespace std;

long long a;
long long b;
long long c;

long long divide(long long n) {
	if(n == 1)  return a % c;

	long long tmp = divide(n / 2);

	if (n % 2 == 0) return tmp * tmp % c;
	else return (tmp * tmp % c) * a % c;
}

int main() {
	cin >> a >> b >> c;
	cout << divide(b)<<"\n";
	return 0;
}