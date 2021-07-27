N = int(input())
liquid = list(map(int, input().split()))
liquid.sort()

left = 0
right = N - 1
answer = abs(liquid[left] + liquid[right])
al = left
ar = right

while left < right:
    temp = abs(liquid[left] + liquid[right])
    if answer > abs(temp):
        answer = abs(temp)
        al = left
        ar = right
        if answer == 0:
            break

    if temp < 0:
        left += 1
    else:
        right -= 1

print(liquid[al], liquid[ar])