#!/usr/bin/env python3
# coding:utf-8

class Solution:
    def palindromeSubstring(self, s):
        length = len(s)
        if length == 1:
            return s
        curr = ''
        result = ''
        pos = 0

        while pos < length:
            if pos == length - 1:
                if s[pos] == s[pos - 1]:
                    while pos - 1 >= 0:
                        if s[pos] == s[pos - 1]:
                            curr += s[pos - 1]
                            pos -= 1
                    if len(curr) > len(result):
                        result = curr
                    
            elif pos == length - 2:
                if s[pos] == s[pos + 1]:
                    curr = s[pos: pos + 2]
                    if len(curr) > len(result):
                        result = curr
                    return result
                if s[pos] != s[pos + 1]:
                    if result == '':
                        return s[pos]
  
            
            elif s[pos] == s[pos + 2]:
                curr = s[pos: pos + 3]
                width = 1
                while (pos - width > -1) and (pos + 2 + width < length):
                    left = s[pos - width]
                    right = s[pos + 2 + width]
                    if left != right:
                        break
                    curr = left + curr + right
                    width += 1
                if len(curr) > len(result):
                    result = curr
                    print(result)
               
            elif s[pos] == s[pos + 1]:
                curr = s[pos: pos + 2]
                width = 1
                while (pos - width > -1) and (pos + 1 + width < length):
                    left = s[pos - width]
                    right = s[pos + 1 + width]
                    if left != right:
                        break
                    curr = left + curr + right
                    width += 1

                flag = True
                for i in range(len(curr) - 1):
                    if curr[i] != curr[i + 1]:
                        flag = False
                        break
                if flag == True:
                    new_pos = int(pos + len(curr)/2 + 1)
                    end = len(curr) - 1
                    while new_pos < length:
                        if curr[end] == s[new_pos]:
                            curr += s[new_pos]
                            new_pos += 1
                        else: 
                            break

                if len(curr) > len(result):
                    result = curr         
 
            pos += 1

        return result

#testCase
x = Solution()
result = x.palindromeSubstring("babad")
assert (len(result) == 3), "case 1 failed"
print("case 1 passed")
result = x.palindromeSubstring("cbbd")
assert (len(result) == 2), "case 2 failed"
print("case 2 passed")
result = x.palindromeSubstring("bb")
assert (len(result) == 2), "case 3 failed"
print("case 3 passed")
result = x.palindromeSubstring("rabccdccbasabccba")
assert (len(result) == 9), "case 4 failed"
print("case 4 passed")
result = x.palindromeSubstring("ac")
assert (result == 'a'), "case 5 failed"
print("case 5 passed")
result = x.palindromeSubstring("aaabaaaa")
assert (len(result) == 7), "case 6 failed"
print("case 6 passed")
result = x.palindromeSubstring("cccc")
assert (len(result) == 4), "case 7 failed"
print("case 7 passed")
               
               


                
        
