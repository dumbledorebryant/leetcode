#!/usr/bin/env python3
#coding:utf-8

class Solution:
    def plusOne(self, digits):
        length = len(digits)
        carry = 0
        digits[length - 1] += 1

        for i in range(length):
            print(digits[length - 1 - i])
            digits[length - 1 - i] += carry
            carry = digits[length - 1 - i]//10
            print(carry)
            if carry > 0:
                digits[length -1 - i] -= 10

        if digits[0] == 0:
            digits.append(0)
            print('add a bit')
        
            for i in range(length):
                digits[i + 1] == digits[i]
            
            digits[0] = 1
        print(digits)
        return digits


#testCase
x = Solution()
result = x.plusOne([1, 2, 3])
assert (result == [1, 2, 4]), "case 1 failed"
print("case 1 passed")
result = x.plusOne([0])
assert (result == [1]), "case 2 failed"
print("case 2 passed")
result = x.plusOne([9])
assert (result == [1, 0]), "case 3 failed"
print("case 3 passed")
result = x.plusOne([1, 9])
assert (result == [2, 0]), "case 4 failed"
print("case 4 passed")
result = x.plusOne([8, 9, 9])
assert (result == [9, 0, 0]), "case 5 failed"
print("case 5 passed")
result = x.plusOne([5])
assert (result == [6]), "case 6 failed"
print("case 6 passed")
result = x.plusOne([9, 9])
assert (result == [1, 0, 0]), "case 7 failed"
print("case 7 passed")

