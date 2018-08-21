#!/usr/bin/env python3
# coding:utf-8

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        i, j = 0, 0
        op1, op2 = 0, 0
        while l1.val != None:
            op1 += ((10**i) * l1.val)
            if l1.next == None:
                break
            l1 = l1.next
            i += 1

        while l2.val != None:
            op2 += ((10**j) * l2.val)
            if l2.next == None:
                break
            l2 = l2.next
            j += 1

        result = op1 + op2

        head = ListNode(result % 10)
        tail = head
        print(result % 10)

        while True:
            result = result//10
            if result == 0:
                return head
            print(result % 10)
            tail.next = ListNode(result % 10)
            tail = tail.next

        return head
          
        



# testCase
l1 = ListNode(0)
l1.next = ListNode(4)
#l1.next.next = ListNode(3)
l2 = ListNode(0)
l2.next = ListNode(6)
#l2.next.next = ListNode(4)
x = Solution()
result = x.addTwoNumbers(l1, l2)
