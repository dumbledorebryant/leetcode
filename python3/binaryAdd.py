#!/usr/bin/env python3
#coding:utf-8

class Solution:
    def addBinary(self, a, b):
        result = ''
        length_a = len(a)
        length_b = len(b)
        length = 0
        
        diff = abs(length_a - length_b)
        if length_a > length_b:
            b = '0' * diff + b
            length = length_a
            print("a")

        elif length_b > length_a:
            a = '0' * diff + a
            length = length_b
            print("b")

        else:
            length = length_a
            print("=")

        carry = 0
        for pos in range(length):
            num_a = int(a[length - 1 - pos])
            num_b = int(b[length - 1 - pos])

            num_bit = num_a + num_b + carry
            carry = num_bit//2
            if carry == 1:
                num_bit -= 2

            result += str(num_bit)
            print(result)
        
        reverse = ''
        for i in range(length):
            reverse += result[length - 1 - i]

        result = reverse
        if carry == 1:

            tmp = '1'
            for i in range(length):
                tmp += result[i]

            result = tmp 

        print(result)
        return result


#testCase
x = Solution()
result = x.addBinary('11', '1')
assert (result == '100'), "case 1 failed"
print("case 1 passed")
result = x.addBinary('0', '0')
assert (result == '0'), "case 2 failed"
print("case 2 passed")
result = x.addBinary('1010', '1011')
assert (result == '10101'), "case 3 failed"
print("case 3 passed")
result = x.addBinary('1111', '1001001001')
assert (result == '1001011000'), "case 4 failed"
print("case 4 passed")
result = x.addBinary('1', '1')
assert (result == '10'), "case 5 failed"
print("case 5 passed")






        
        

            
            
