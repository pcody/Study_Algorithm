import sys

# 실패했던 코드를 봤는데 뭘 이렇게 복잡하게 풀었을까...
# 단순히 left부터 k개 까지만 비교하면 되는데
# 조건에 맞을때마다 큐에 넣고 빼고 마지막에 다시 개수까지 세고..

N, d, k, c = map(int, sys.stdin.readline().split())
sushis = []
for i in range(1, N + 1):
    sushis.append(int(sys.stdin.readline().rstrip()))

left = -1
dish = set()
answer = 0
while left < N:
    left += 1
    dish.clear()
    for right in range(left, left + k):
        right %= N
        dish.add(sushis[right])
    dish.add(c)

    answer = max(answer, len(dish))

print(answer)