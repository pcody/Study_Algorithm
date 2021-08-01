import sys
import collections

N, d, k, c = map(int, sys.stdin.readline().split())
sushi = []
for i in range(N):
    sushi.append(int(sys.stdin.readline().rstrip()))

eat = collections.deque()
front = -1
rear = 0
dishes = set()
answer = 0

while front < N:
    rear %= N
    if eat != []:
        if sushi[rear] not in eat and len(eat) < k:
            eat.append(sushi[rear])
            rear += 1
        else:
            dishes.add(tuple(eat))
            front += 1
            eat.popleft()
    else:
        eat.append(sushi[rear])
dishes.add(tuple(eat))
# print(dishes)

while dishes:
    dish = dishes.pop()
    n = len(dish)

    if c not in dish:
        temp = n + 1
    else:
        temp = n
    if answer < temp:
        answer = temp

print(answer)