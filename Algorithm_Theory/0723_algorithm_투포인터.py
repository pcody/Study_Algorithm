import sys

# 배열의 부분합을 구하는 경우
# 반복문을 사용하는 경우 시간복잡도가 크게 증가할 수 있다.
# 이런 경우 front와 rear 인덱스를 두고 인덱스를 증가시키며 부분합을 계산하면
# 보다 빠르게 계산할 수 있다.

# 백준 2003번 수들의합2 다시 풀어보기..

N, M = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

front, rear = -1, 0
sumFront, sumRear = 0, A[0]
cnt = 0
while front < N-1:
    subSum = sumRear - sumFront
    if subSum < M:
        if rear < N-1:
            rear += 1
            sumRear += A[rear]
        elif rear == N-1:
            if front < N-1:
                front += 1
                sumFront += A[front]
    else:
        if subSum == M:
            cnt += 1

        if front < N-1:
                front += 1
                sumFront += A[front]
            
print(cnt)
