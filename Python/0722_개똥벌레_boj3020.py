## 다시 풀어볼것...

import sys

N, H = map(int, sys.stdin.readline().split())
length1 = []
length2 = []
for i in range(N):
    if i % 2 == 0:
        length1.append(int(sys.stdin.readline().rstrip()))
    else:
        length2.append(int(sys.stdin.readline().rstrip()))

length1.sort()
length2.sort()
cntList = []
for i in range(1, 1 + H):
    # bottom
    l, r = 0, len(length1) - 1
    cnt1 = 0
    while l <= r:
        mid = (l + r) // 2
        if length1[mid] >= i:
            cnt1 = len(length1) - mid
            r = mid - 1
        else:
            l = mid + 1
    
    # top
    l, r = 0, len(length2) - 1
    cnt2 = 0
    while l <= r:
        mid = (l + r) // 2
        if H - length2[mid] < i:
            cnt2 = len(length2) - mid
            r = mid - 1
        else:
            l = mid + 1
    cntList.append(cnt1 + cnt2)
result = min(cntList)
print(result, cntList.count(result))


# H = 5
# 1 1 2 3 3 3 4 5
# 4 4 3 2 2 2 1 0 1층 1
#                 2층 2



