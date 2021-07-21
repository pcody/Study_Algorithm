## 다시 풀어보기...

import sys

N, C = map(int, sys.stdin.readline().split())
X = []
for i in range(N):
    X.append(int(sys.stdin.readline().rstrip()))
X.sort()

start = 1
end = X[-1] - X[0]
answer = 0
while start <= end:
    mid = (start + end) // 2
    old = X[0]
    count = 1

    for i in range(1, len(X)):
        if X[i] >= old + mid:
            count += 1
            old = X[i]

    if count >= C:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1

print(answer)

# 5 3
# 1
# 2
# 8
# 4
# 9