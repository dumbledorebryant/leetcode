#!/usr/bin/env python3
# coding:utf-8

class Solution:
    def twoSum(self, nums, target):
        tmp = nums.copy()
        if tmp == None:
            return None
        tmp.sort()
        end = -1
        length = len(tmp)
        for i in range(length):
            if tmp[i] > target:
                end = i
        if end == -1:
            end = length
        for i in range(length):
            for j in range(i, length):
                if j != i:
                    result = tmp[i] + tmp[j]
                    if result > target:
                        continue
                    if result < target:
                        continue
                    if result == target:
                        x = nums.index(tmp[i])
                        nums[x] = -1
                        y = nums.index(tmp[j])
                        if x > y:
                            return [y, x]
                        else:
                            return [x, y]


# testCase1
nums = [3, 3]
target = 6
x = Solution()
result = x.twoSum(nums, target)
assert (result == [0, 1]), "case 1 failed"
print("case 1 passed")

# testCase2
nums = [7, 11, 2, 15]
target = 9
y = Solution()
result = y.twoSum(nums, target)
assert (result == [0, 2]), "case 2 failed"
print("case 2 passed")

# testCase3
nums = [0, 0]
target = 0
z = Solution()
result = z.twoSum(nums, target)
assert (result == [0, 1]), "case 3 failed"
print("case 3 passed")

# testCase4
nums = [0, 1, 2, 0]
target = 0
m = Solution()
result = m.twoSum(nums, target)
assert (result == [0, 3]), "case 4 failed"
print("case 4 passed")





