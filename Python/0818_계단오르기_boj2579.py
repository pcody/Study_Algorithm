import sys

# res[N] = max(dp(N-2) + scores[N], dp(N-3) + scores[N-1] + scores[N])
def dp(N, scores):
    global res
    
    res[1] = scores[1]
    if N == 1:
        return res[1]

    res[2] = scores[1] + scores[2]
    if N == 2:
        return res[2]

    res[3] = max(res[1] + scores[3], scores[2] + scores[3])
    if N == 3:
        return res[3]

    for i in range(4, N + 1):
        res[i] = max(res[i - 2] + scores[i], res[i - 3] + scores[i - 1] + scores[i])
    
    return res[N]
        
N = int(sys.stdin.readline().rstrip())
scores = [0]
for _ in range(N):
    scores.append(int(sys.stdin.readline().rstrip()))
res = [-1] * (N + 1)

print(dp(N, scores))