#include <iostream>
using namespace std;

int num[1000001]{};

int main()
{
	int m, n;
	cin >> m >> n;

	for (int i = 2; i <= n; i++)
	{
		num[i] = i;
	}

	for (int i = 2; i * i <= n; i++)
	{
		if (num[i] == 0) continue;
		for (int j = i * i; j <= n; j += i)	num[j] = 0;
	}

	for (int i = m; i <= n; i++)
	{
		if (num[i] != 0) cout << num[i] << '\n';
	}
	return 0;
}