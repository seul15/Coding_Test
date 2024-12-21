#include<iostream>
using namespace std;

int main()
{
	int ans = 0;
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		if (i % 5 == 0)		//	5의 배수일 때
		{
			ans++;
			if (i % 25 == 0)		
				ans++;
			if (i % 125 == 0)		
				ans++;
		}
	}

	cout << ans<<"\n";
}