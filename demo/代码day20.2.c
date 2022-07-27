//非递归实现
#include <stdio.h>
int climbStairs(int n)
{
	if (n == 1||n == 2)
	{
		return n;
	}
	int dp[n+1];
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= n; i++)
	{
		dp[i] = dp[i - 1] + dp[i - 2];
	}
}