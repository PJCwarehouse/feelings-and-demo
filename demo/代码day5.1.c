#include<stdio.h>
int main()
{
	int temp;
	int Insert[10] = { 2,23,4,5,1,3,34,62,22 };
	for (int i = 1; i < 10; i++)
	{
		temp = Insert[i];
		if (Insert[i] < Insert[i - 1]) 
		{
			for (int j = i - 1; j >= 0 && Insert[j + 1] < Insert[j]; j--)
			{ 
				Insert[j + 1] = Insert[j];
				Insert[j] = temp;				
			}
		}
		for (int i = 0; i < 10; i++)//局部声明的i，屏蔽了外部作用域中具有相同名称的声明
		{
			printf("%d ", Insert[i]);
		}
		printf("\n");
	}
	return 0;
}