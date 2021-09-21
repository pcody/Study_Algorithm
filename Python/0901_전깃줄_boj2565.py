import sys

def dp(N, lines):
    res = [0] * (N + 1)
    answer = 0
    lines.sort()
    # 왼쪽 전봇대를 기준으로 정렬시키면
    # 최대 연결할 수 있는 전깃줄의 개수는 증가하는 부분 수열의 최대 길이를 구하면 된다
    # Longest Increasing Subsquence
    # 그리고 최종 N에서 최대 길이를 빼면 제거해야하는 전깃줄의 최소개수를 알 수 있다
    
    for i in range(1, N + 1):
        temp = 0
        for j in range(1, i):
            if lines[j][1] < lines[i][1]:
                temp = max(temp, res[j])
        res[i] = temp + 1
        answer = max(answer, res[i])

    return answer
    
N = int(sys.stdin.readline().rstrip())
lines = [[0, 0]]
for _ in range(N):
    lines.append(list(map(int, sys.stdin.readline().split())))
print(N - dp(N, lines))