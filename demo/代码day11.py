def erfen(nums,target):
    left,right = 0,len(nums)
    while left <= right :
        mid = (left + right)//2
        if nums[mid] > target:
            right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
        else:
            return mid
    return -1