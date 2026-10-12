class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0

        currentValue = nums[0]
        insertIndex = 1
        for i in range(1, len(nums)):
            if nums[i] == currentValue:
                continue

            nums[insertIndex] = nums[i]
            currentValue = nums[i]
            insertIndex += 1

        return insertIndex

sol = Solution()
nums1 = [1,1,2]
print(sol.removeDuplicates(nums1))
print(nums1)

nums2 = [0,0,1,1,1,2,2,3,3,4]
print(sol.removeDuplicates(nums2))
print(nums2)
