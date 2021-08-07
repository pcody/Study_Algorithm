import sys;
# sys.setrecursionlimit(10**6);
def nck(N, K):
    global resList;
    if N == 0 or K == 0 or N == K:
        return 1;
    elif K == 1 or K == N-1:
        return N;
    else:
        if resList[N][K] == -1:
            resList[N][K] = nck(N-1, K-1)%10007 + nck(N-1, K)%10007;
            resList[N][K] %= 10007;
        return resList[N][K];

N, K = map(int, input().split());
resList = [[-1] * (K+1) for _ in range(N+1)];
print(nck(N, K));
# print(resList);

# 0 0 = 1
# 1 0 = 1
# 1 1 = 1
# 2 0 = 1
# 2 1 = 1 0 + 1 1
# 2 2 = 1
# 3 0 = 1
# 3 1 = 2 0 + 2 1
# 3 2 = 2 1 + 2 2
# 3 3 = 1
# 4 0 = 1
# 4 1 = 3 0 + 3 1
# 4 2 = 3 1 + 3 2
# 4 3 = 3 2 + 3 3
# 4 4 = 1
# 5 1 = 4 0 + 4 1
# 5 2 = 4 1 + 4 2
# 5 3 = 4 2 + 4 3
# 5 4 = 4 3 + 4 4
# 5 5 = 1