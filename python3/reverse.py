#!/usr/bin/env python3
# coding:utf-8

class Solution:
    def reverse(self, x):
        tmp = x
        sign_bit = 1
        if x < 0:
            tmp = abs(x)
            sign_bit = -1
        
        str_num = str(tmp)
        str_num = str_num[::-1]
        num = int(str_num)
        
        result = int(str_num) * sign_bit
        if (result > 2**30 - 1 + 2**30) or (result < -2**31):
            return 0
        return result


#testCase
x = Solution()
result = x.reverse(123)
assert (result == 321), "case 1 failed"
print("case 1 passed")
result = x.reverse(-123)
assert (result == -321), "case 2 failed"
print("case 2 passed")
result = x.reverse(120)
assert (result == 21), "case 3 failed"
print("case 3 passed")

