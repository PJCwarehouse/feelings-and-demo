C语言方法
#include <stdio.h>
int Sum(int n)
{
    int sum = n;
    sum && (sum += Sum(n - 1));
    return sum;
};
int main()
{
    printf("%d", Sum(10));
    return 0;
}