#!/usr/bin/env python3
#coding:utf-8

class Solution:
    def myatoi(self, str):
        tmp = str
        tmp = tmp.strip()
        if len(tmp) == 0:
            return 0	

        tmp_list = tmp.split(' ')
        tmp = tmp_list[0]
        print(tmp)
        str_num = ''
        result = 0
        
        sign_bit = 1
        if tmp[0] == '-':
            sign_bit = -1
            tmp = tmp[1: ]

        elif tmp[0] == '+':
            sign_bit = 1
            tmp = tmp[1: ]

        length = len(tmp)
        if length == 0:
            return 0

        flag = False
        pos = 0
        while pos < length:
            num = tmp[pos]
            if num == '.':
                break
            if not num.isdigit():
                 break
            else:
                if num == 0:
                    if flag == True:
                        tmp += num
                if num != 0:
                    if flag == False:
                        flag = True
                    str_num += num
            pos += 1

        if len(str_num) == 0:
            return 0
        result = int(str_num) * sign_bit
        max_num = 2**30 - 1 + 2**30
        min_num = -2**31
        if result > max_num:
            return max_num
        if result < min_num:
            return min_num

        return result


#testCase
x = Solution()
result = x.myatoi("42")
assert (result == 42), "case 1 failed"
print("case 1 passed")
result = x.myatoi("    -42")
assert (result == -42), "case 2 failed"
print("case 2 passed")
result = x.myatoi("4193 with words")
assert (result == 4193), "case 3 failed"
print("case 3 passed")
result = x.myatoi("words with 987")
assert (result == 0), "case 4 failed"
print("case 4 passed")
result = x.myatoi("-99990678967")
assert (result == -2**31), "case 5 failed"
print("case 5 passed")
result = x.myatoi("")
assert (result == 0), "case 6 failed"
print("case 6 passed")
result = x.myatoi("          ")
assert (result == 0), "case 7 failed"
print("case 7 passed")
result = x.myatoi("+")
assert (result == 0), "case 8 failed"
print("case 8 passed")
result = x.myatoi("-")
assert (result == 0), "case 9 failed"
print("case 9 passed")
result = x.myatoi("    +0 123")
assert (result == 0), "case 10 failed"
print("case 10 passed")
result = x.myatoi("    00000123")
assert (result == 123), "case 11 failed"
print("case 11 passed")
result = x.myatoi("3.1415926")
assert (result == 3), "case 12 failed"
print("case 12 passed")
result = x.myatoi("   -0012a42")
assert (result == -12), "case 13 failed"
print("case 13 passed")














