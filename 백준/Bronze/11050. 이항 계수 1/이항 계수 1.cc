#include <iostream>

using namespace std;

int Factorial(int _Num)
{
	if (0 == _Num)
	{
		return 1;
	}

	int Result = 1;

	for (int i = _Num; i >= 1; i--)
	{
		Result *= i;
	}

	return Result;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N = 0, K = 0;
	cin >> N >> K;

	cout << Factorial(N) / (Factorial(K) * Factorial(N - K));

	return 0;
}