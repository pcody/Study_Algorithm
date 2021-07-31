import sys

N = int(sys.stdin.readline().rstrip())
liquid = list(map(int, sys.stdin.readline().split()))

liquid.sort()
left = 0
right = N - 1
answer = abs(liquid[left] + liquid[right])
answerList = [liquid[left], liquid[right]]
while left < right:
    mixedLiquid = liquid[left] + liquid[right]
    if mixedLiquid < 0:
        if abs(mixedLiquid) < answer:
            answerList = [liquid[left], liquid[right]]
            answer = abs(liquid[left] + liquid[right])
        left += 1
    elif mixedLiquid == 0:
        answerList = [liquid[left], liquid[right]]
        break
    else:
        if abs(mixedLiquid) < answer:
            answerList = [liquid[left], liquid[right]]
            answer = abs(liquid[left] + liquid[right])
        right -= 1

print(answerList[0], answerList[1])
