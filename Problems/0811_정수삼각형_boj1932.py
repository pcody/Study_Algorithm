#     7
#    3 8
#   8 1 0
#  2 7 4 4
# 4 5 2 6 5

import sys

def dp(n):
    global res, triangle
    res[0][0] = triangle[0][0]
    if n == 1:
        return res[0][0]
    
    for j in range(1, n):
        for i in range(j + 1): # j=1, i:0~1 / j=2, i:0~2
            if i != 0 and i != j:
                res[j][i] = max(res[j-1][i-1], res[j-1][i]) + triangle[j][i]
            elif i == 0:
                res[j][i] = res[j-1][i] + triangle[j][i]
            else:
                res[j][i] = res[j-1][i-1] + triangle[j][i]

    return max(res[n-1])

n = int(sys.stdin.readline().rstrip())
triangle = []
for i in range(n):
    triangle.append(list(map(int, sys.stdin.readline().split())))
res = [[0] * i for i in range(1, n + 1)]
print(dp(n))