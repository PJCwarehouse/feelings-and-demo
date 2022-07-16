二分查找：
前提条件：1.查找的序列必须是有序的2.查找的对象只有一个，不能有多个
二分查找有很多种变体，使用时需要注意**查找条件，判断条件和左右边界的更新方式**
注意：在whlie循环中的条件
当数组区间为[left,right]左右都是闭区间时，条件使用left <= right;
当数组区间为[left,right)左闭右开时，条件使用left < right,否则在找不到tagert时，程序会进入死循环]
方法一：
while循环
方法二：递归，例如：
public class SearchNum 
    {
    public static void main(String[] args){
        int []nums = {2,3,4,5,6,7,8,9};
        System.out.print(binarySearch(nums,0,nums.length-1,6));
    }
 
    private static int binarySearch(int[] arr, int L, int R, int key) {
 
        if (L > R) {    //元素key不存在
            return -1;
        }
        int M = (L + R) / 2;
        if (arr[M] == key) {
            return M;
        }
        if (arr[M] < key) {
            return binarySearch(arr,M + 1, R, key);
        } else {
            return binarySearch(arr,L, M - 1, key);
        }
    }
}
二分查找左右边界：https://segmentfault.com/a/1190000016825704
查找左边界时，当nums[mid] >= target时，right = mid(收缩边界)
查找右边界时对称即可
#时间复杂度和空间复杂度
1.时间复杂度根据基本操作的执行次数来判定
2.空间复杂度根据一个算法在运行过程中 临时占用存储空间大小的量度来判定，空间复杂度算的是变量的个数