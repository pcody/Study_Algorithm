import sys

def dp(N, A, res):
    for i in range(N):
        if i == 0:
            res[i] = A[i]
        else:
            idx = binarySearch(N, A[i], res)
            res[idx] = A[i]

    answer = 0
    for i in range(N):
        if res[i] != sys.maxsize:
            answer += 1
        else:
            break
    return answer

def binarySearch(N, a, res):
    left = 0
    right = N - 1
    idx = 0

    while left <= right:
        mid = (left + right) // 2

        if a < res[mid]:
            right = mid - 1
        else:
            left = mid + 1
    idx = left
    return idx - 1

# N = int(sys.stdin.readline().rstrip())
# A = list(map(int, sys.stdin.readline().split()))
# res = [sys.maxsize] * N
# print(dp(N, A, res))

def binarySearch2(arr, T):
    retIdx = 0

    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] < T:
            left = mid + 1
        else:
            right = mid - 1
    retIdx = max(0, left)
    return retIdx
    
print(binarySearch(7, 10, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 10))
print(binarySearch(7, 15, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 15))
print(binarySearch(7, 20, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 20))
print(binarySearch(7, 30, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 30))
print(binarySearch(7, 40, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 40))
print(binarySearch(7, 45, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 45))
print(binarySearch(7, 50, [10,10,20,30,40,40,50]), binarySearch2([10,10,20,30,40,40,50], 50))

