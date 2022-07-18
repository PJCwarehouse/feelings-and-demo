二分查找：
前提条件：1.查找的序列必须是有序的2.查找的对象只有一个，不能有多个
二分查找有很多种变体，使用时需要注意**查找条件，判断条件和左右边界的更新方式**
注意：在whlie循环中的条件
当数组区间为[left,right]左右都是闭区间时，条件使用left <= right;
当数组区间为[left,right)左闭右开时，条件使用left < right,否则在找不到tagert时，程序会进入死循环。
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
#二分查找最后mid和left总是在同一侧(即mid偏左)
left + ((right -left) >> 1) 对于目标区域长度为奇数而言，是处于正中间的，对于长度为偶数而言，是中间偏左的。因此左右边界相遇时，只会是以下两种情况：
left/mid , right (left, mid 指向同一个数，right指向它的下一个数)
left/mid/right （left, mid, right 指向同一个数）
**即因为mid对于长度为偶数的区间总是偏左的，所以当区间长度小于等于2时，mid 总是和 left在同一侧。**
#查找左边界时
最后left与right相邻的时候，mid和left处于相同的位置(前面说过，mid偏左)，则下一步，无论怎样，left, mid, right都将指向同一个位置，如果此时循环的条件是left <= right，则我们需要再进入一遍循环，此时，如果nums[mid] < target还好说，循环正常终止(此时即为没有找到target值)；否则，我们会令right = mid，这样并没有改变left,mid,right的位置，将进入死循环。
#时间复杂度和空间复杂度
1.时间复杂度根据基本操作的执行次数来判定
2.空间复杂度根据一个算法在运行过程中 临时占用存储空间大小的量度来判定，空间复杂度算的是变量的个数