import sys

N, M = map(int, sys.stdin.readline().split())
lessons = list(map(int, sys.stdin.readline().split()))


minimum = max(lessons)
maximum = sum(lessons)
answer = 0
while minimum <= maximum:
    bluelay = (minimum + maximum) // 2
    cnt = 0
    subSum = 0
    
    for i in range(N):
        subSum += lessons[i]
        if subSum > bluelay:
            subSum = lessons[i]
            cnt += 1

    if cnt >= M:
        minimum = bluelay + 1
        answer = minimum
    else:
        maximum = bluelay - 1

print(bluelay)
print(minimum)
print(answer)