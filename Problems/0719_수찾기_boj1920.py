import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline().rstrip())
B = list(map(int, sys.stdin.readline().split()))

def binSearch(A, target):
    left = 0
    right = len(A)-1
    while left <= right:
        mid = (left + right) // 2
        if A[mid] == target:
            return 1
        elif A[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return 0

A.sort()
for target in B:
    print(binSearch(A, target))