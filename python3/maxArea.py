#!/usr/bin/env python3
#coding:utf-8

class Solution:
    def maxArea(self, height):
        maxArea = 0
        length = len(height)
        
        for i in range(1, length):
            for j in range(0, i):
                area = (i - j) * min(height[j], height[i])
                if area > maxArea:
                    maxArea = area

        return maxArea


#testCase
x = Solution()
result = x.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])
assert (result == 49), "case 1 failed"
print("case 1 passed")
result = x.maxArea([1, 8])
assert (result == 1), "case 2 failed"
print("case 2 passed")
result = x.maxArea([1, 8, 6, 2])
assert (result == 6), "case 3 failed"
print("case 3 passed")
result = x.maxArea([1, 8, 6, 0])
assert (result == 6), "case 3 failed"
print("case 3 passed")
result = x.maxArea([0, 0])
assert (result == 0), "case 4 failed"
print("case 4 passed")









        
