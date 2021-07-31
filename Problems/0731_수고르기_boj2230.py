import sys

N, M = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline().rstrip()))

arr.sort()
left = 0
right = 1

answer = sys.maxsize
while left < N - 1:
    diff = arr[right] - arr[left]
    if diff >= M:
        answer = min(answer, diff)
        left += 1
        # 기존 풀이와 똑같아서 놀랐다
        # 여기서 더 작은 차이를 찾으려면 right을 +1 하지 않고 고정시키는게 맞는 것 같다
        # 근데 답은 나오네
        # right = left + 1
    else:
        if right < N-1:
            right += 1
        else:
            left += 1

print(answer)