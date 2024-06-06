#include <iostream>
#include <vector>

using namespace std;

int main() 
{
	vector<int> Number(6);

	for (int i = 0; i < 6; i++)
	{
		cin >> Number[i];
	}

	vector<int> CorrectSet = { 1, 1, 2, 2, 2, 8 };

	for (int i = 0; i < 6; i++)
	{
		cout << CorrectSet[i] - Number[i] << " ";
	}

}