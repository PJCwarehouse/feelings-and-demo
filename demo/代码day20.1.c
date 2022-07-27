//递归实现
#include <stdio.h>
int climbStairs(int n)
{
	if (n == 1 || n == 2)
		return n;
	else
		return climbStairs(n - 1) + climbStairs(n - 2);
}
int main()
{
	printf("%d", climbStairs(10));
	return 0;
}