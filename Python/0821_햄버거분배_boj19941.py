import sys

N, K = map(int, sys.stdin.readline().split())
hamburger = list(sys.stdin.readline().rstrip())
visited = [0] * N
for i in range(N):
    if hamburger[i] == 'P':
        visited[i] = 1

answer = 0
for i in range(N):
    flag, k = 0, K + 1
    if hamburger[i] == 'P':
        # 왼쪽 k번째부터 햄버거를 먹는다
        while flag == 0 and k > 1:
            k -= 1
            if i - k >= 0 and visited[i - k] == 0:
                visited[i - k] = 1
                flag = 1
                answer += 1
        # 오른쪽 1번째부터 K번째 까지 햄버거를 찾아서 먹는다
        k = 0
        while flag == 0 and k < K:
            k += 1
            if i + k < N and visited[i + k] == 0:
                visited[i + k] = 1
                flag = 1
                answer += 1
print(answer)
