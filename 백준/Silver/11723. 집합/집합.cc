#include<iostream>
using namespace std;

bool num[21];

int main()
{
    cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	string order;
	int order_num;
	int M;
	cin >> M;
	for (int i = 0; i < M; i++)
	{
		cin >> order;
		if (order == "add")
		{
			cin >> order_num;
			num[order_num] = true;
		}
		else if (order == "remove")
		{
			cin >> order_num;
			num[order_num] = false;
		}
		else if (order == "check")
		{
			cin >> order_num;
			cout << num[order_num] << '\n';
		}
		else if (order == "toggle")
		{
			cin >> order_num;
			if (num[order_num] == 0) num[order_num] = 1;
			else num[order_num] = 0;
		}
		else if (order == "all")
		{
			for (int j = 1; j < 21; j++)
			{
				num[j] = 1;
			}
		}
		else if (order == "empty")
		{
			for (int j = 1; j < 21; j++)
			{
				num[j] = 0;
			}
		}
	}
	return 0;
}