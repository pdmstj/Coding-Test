#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector<vector<int>> Tech;
vector<int> InDegree;
vector<int> BulidTimes;
vector<int> Results;
vector<int> MaxTime;

int Topology(int _Target)
{
	queue<int> Que;
	for (size_t i = 1; i < Tech.size(); i++)
	{
		if (0 == InDegree[i])
		{
			Que.push(static_cast<int>(i));
			MaxTime[i] = BulidTimes[i];
		}
	}

	while (!Que.empty())
	{
		int Cur_Node = Que.front();
		Que.pop();

		for (size_t i = 0; i < Tech[Cur_Node].size(); i++)
		{
			int Next_Node = Tech[Cur_Node][i];
			MaxTime[Next_Node] = max(MaxTime[Next_Node], MaxTime[Cur_Node] + BulidTimes[Next_Node]);
			--InDegree[Next_Node];

			if (0 == InDegree[Next_Node])
			{
				Que.push(static_cast<int>(Next_Node));
			}
		}
	}

	return MaxTime[_Target];
}

void System(int _SystemCount)
{
	int System = _SystemCount;
	while (0 != System)
	{
		int N = 0, K = 0;
		cin >> N >> K;
		
		Tech.resize(N + 1);
		InDegree.resize(N + 1, 0);
		BulidTimes.resize(N + 1, 0);
		MaxTime.resize(N + 1, 0);

		for (int i = 1; i < N + 1; i++)
		{
			cin >> BulidTimes[i];
		}

		for (int i = 0; i < K; i++)
		{
			int A = 0, B = 0;
			cin >> A >> B;
			Tech[A].push_back(B);
			++InDegree[B];
		}

		int Target = 0;
		cin >> Target;
		Results.push_back(Topology(Target));

		Tech.clear();
		MaxTime.clear();
		InDegree.clear();
		BulidTimes.clear();
		--System;
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int SystemCount = 0;
	cin >> SystemCount;
	System(SystemCount);

	for (int i = 0; i < SystemCount; i++)
	{
		cout << Results[i] << '\n';
	}

	return 0;
}