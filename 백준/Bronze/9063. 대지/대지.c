#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX_POINTS 100000

int main(void)
{
	int N;
	scanf("%d", &N);

	int x[MAX_POINTS];
	int y[MAX_POINTS];
	int area;

	for (int i = 0; i < N; i++)
	{
		scanf("%d %d", &x[i], &y[i]);
	}
	int min_x = x[0];
	int max_x = x[0];
	int min_y = y[0];
	int max_y = y[0];

	for (int i = 1; i < N; i++)
	{
		if (max_x < x[i])
			max_x = x[i];

		if (min_x > x[i])
			min_x = x[i];

		if (max_y < y[i])
			max_y = y[i];

		if (min_y > y[i])
			min_y = y[i];
	}

	if (N == 1)
	{
		printf("0");
	}

	else
	{
		area = (max_x - min_x) * (max_y - min_y);
		printf("%d", area);
	}

	return 0;
}