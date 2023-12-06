class Solution(object):
    def twoSum(self,nums, target):
        n = len(nums)
        for i in range(1,n):
            term = nums[:i]
            if target-nums[i] in term:
                j = term.index(target-nums[i])
                break
        if j >= 0:
            return [j,i]