import sys

N, M = map(int,sys.stdin.readline().split())
heights = list(map(int,sys.stdin.readline().split()))
heights.sort()

def binarySearch(arr, M):
    global answer
    start = 0
    end = arr[-1]
    while start <= end:
        mid = (start + end) // 2
        heightSum = 0
        for height in heights:
            if height > mid:
                heightSum += height - mid
        if heightSum >= M:
            start = mid + 1
            answer = mid
        else:
            end = mid - 1

answer = 0
binarySearch(heights, M)
print(answer)

## 다시 풀어보기