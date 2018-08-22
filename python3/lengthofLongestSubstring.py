#!/usr/bin/env python3
# coding:utf-8

class Solution:
    def longestSubstring(self, s):
        curr = ''
        result = ''

        pos = 0
        while pos < len(s):
            if s[pos] in curr:
                if len(curr) > len(result):
                    result = curr
                lastpos = s.index(s[pos]) + 1
                s = s[lastpos:]
                pos = 0
                if len(s) == 0:
                    return len(result)
                curr = s[pos]
            else:
                curr += s[pos]
            pos += 1 

        if len(curr) > len(result):
            result = curr

        return len(result)


#testCase1
x = Solution()
result = x.longestSubstring('abcdarfawa')
assert (result == 6), "case 1 failed"
print("case 1 passed")
        

