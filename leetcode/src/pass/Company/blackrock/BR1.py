import sys
stack = []
flag = True
valid_list = ['(', ')', '[', ']', '{', '}']

for line in sys.stdin:
    line = line.strip()
    count = 0
    for i in line:
        if i not in valid_list:
            continue
        if i == '(':
            stack.append(')')
            count += 1
        elif i == '[':
            stack.append(']')
        elif i == '{':
            stack.append('}')
        else:
            if stack == []:
                flag = False
                print("invalid")
                break
            elif i != stack[-1]:
                flag = False
                print("invalid")
                break
            elif i == ')' and i == stack[-1]:
                count -= 1
                stack.pop()
            else:
                stack.pop()
    if count != 0 and flag == True:
        flag = False
        print("invalid")
        break
if flag == True:
    if stack == []:
        print("valid")
    else:
        print("invalid")