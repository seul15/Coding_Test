#include <iostream>
#include <algorithm>

using namespace std;
string num;

int main()
{
	cin >> num;
	sort(num.begin(), num.end(), greater<char>());
	cout << num;
	return 0;
}