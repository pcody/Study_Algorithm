import sys
from collections import defaultdict

N = int(sys.stdin.readline())
arr = defaultdict(list)
answer = []
for i in range(1, N + 1):
    w, h = map(int, sys.stdin.readline().split())
    arr[i] = [w, h]

answerList = defaultdict(int)
arrList = list(arr.items())
print(arrList)
rank = [1] * (N + 1)
for i in range(N):
    for j in range(N):
        if i == j:
            continue
        if arrList[i][1][0] < arrList[j][1][0] and arrList[i][1][1] < arrList[j][1][1]:
            rank[arrList[i][0]] += 1

for i in range(N):
    print(rank[arrList[i][0]], end = " ")