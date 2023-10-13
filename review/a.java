public class a
    {
    public static void main(String[] args){
        int []nums = {2,3,4,5,7,8,9};
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