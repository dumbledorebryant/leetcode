#!/usr/bin/env python3
# coding:utf-8

class Solution:
    def isPalindrome(self, x):
        if x < 0:
            return False
        
        str_num = str(x)
        print(str_num)
        
        length = len(str_num)
        print(length)
        if length == 1:
            return True

        half = length//2
        print(half)
        end_index = length - 1
        for i in range(half):
            if str_num[i] != str_num[end_index - i]:
                return False
        
        return True


#testCase
x = Solution()
result = x.isPalindrome(121)
assert (result == True), "case 1 failed"
print("case 1 passed")
result = x.isPalindrome(1)
assert (result == True), "case 2 failed"
print("case 2 passed")
result = x.isPalindrome(0)
assert (result == True), "case 3 failed"
print("case 3 passed")
result = x.isPalindrome(10)
assert (result == False), "case 4 failed"
print("case 4 passed")
result = x.isPalindrome(-100)
assert (result == False), "case 5 failed"
print("case 5 passed")
result = x.isPalindrome(1111)
assert (result == True), "case 6 failed"
print("case 6 passed")
result = x.isPalindrome(11)
assert (result == True), "case 7 failed"
print("case 7 passed")
