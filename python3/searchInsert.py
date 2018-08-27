#!/usr/bin/env python3
#coding:utf-8

class Solution:
    def searchInsert(self, nums, target):
        tmp = nums
        length = len(tmp)
        mid = length//2
        while length > 1:
            print(tmp[mid])
            print("the left length is:", length)
            if tmp[mid] > target:
                tmp = tmp[:mid]
            else:
                tmp = tmp[mid:]
            length = len(tmp)
            mid = length//2
         
        final_num = tmp[0]
        print(final_num)
        index = nums.index(final_num)
        if target > final_num:
            return index + 1
        else:
            return index

#testCase
x = Solution()
result = x.searchInsert([1, 2, 3, 4], 5)
assert (result == 4), "case 1 failed"
print("case 1 passed")
result = x.searchInsert([1, 2, 3, 5], 4)
assert (result == 3), "case 2 failed"
print("case 2 passed")
result = x.searchInsert([1, 2, 3, 4], 0)
assert (result == 0), "case 3 failed"
print("case 3 passed")
result = x.searchInsert([1, 2, 3, 4], 2)
assert (result == 1), "case 4 failed"
print("case 4 passed")
result = x.searchInsert([1, 2], 1)
assert (result == 0), "case 5 failed"
print("case 5 passed")
result = x.searchInsert([1,], 3)
assert (result == 1), "case 6 failed"
print("case 6 passed")

