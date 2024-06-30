#include <iostream>
#include <algorithm>
#include<vector>;
using namespace std;

int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	while (true)
	{
		int n;
		cin >> n;
		// 종료
		if (n == -1)
		{
			break;
		}

		int sum = 0;
		vector<int> vec;
		// 홀수 제외
		if (n % 2 != 0)
		{
			cout << n << " is NOT perfect." << '\n';;
		}
		else
		{
			//약수 구하기
			for (int i = 1; i <= n / 2; i++)
			{
				if (n % i == 0)
				{
					sum += i;
					vec.push_back(i);
				}
			}
			// 완전수 판단
			if (sum == n)
			{
				cout << n << " = ";
				for (int i = 0; i < vec.size() - 1; i++)
				{
					cout << vec[i] << " + ";
				}
				cout << vec[vec.size() - 1] << '\n';;
			}
			else
			{
				cout << n << " is NOT perfect." << '\n';
			}
		}
	}

	return 0;
}