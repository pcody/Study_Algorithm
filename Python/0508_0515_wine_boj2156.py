# def solve(n):
#     global res;
#     if n == 1:
#         if res[0][n] == -1 or res[1][n] == -1:
#             res[0][n] = wine[n - 1];
#             res[1][n] = 0;
#         return max(res[0][n], res[1][n]);
#     elif n == 2:
#         if res[0][n] == -1 or res[1][n] == -1:
#             res[0][n] = wine[n - 2] + wine[n - 1];
#             res[1][n] = wine[n - 2];
#         return max(res[0][n], res[1][n]);
#     else:
#     # n 번째를 마시면 0번에
#     # n 번째를 안 마시면 1번에
#         if res[0][n] == -1 or res[1][n] == -1:
#             res[0][n] = max(solve(n - 2), solve(n - 1)) + wine[n - 1];
#             res[1][n] = solve(n - 1);
#         return max(res[0][n], res[1][n]);

def dp(step, eat):
    global maxWine, wine
    if step == 1:
        if res[eat][step] == -1:
            if eat:
                res[eat][step] += wine[step-1]
                return res[eat][step]
            else:
                res[eat][step] = 0
                return res[eat][step]
        else:
            return res[eat][step]
    elif step == 2:
        if res[eat][step] == -1:
            if eat:
                res[eat][step] += wine[step-1]
                return res[eat][step]
            else:
                res[eat][step] = max(dp(step-1, 1), dp(step-1, 0))
                return res[eat][step]
        else:
            return res[eat][step]
    else:
        if res[eat][step] == -1:
            if eat:
                res[eat][step] += (max(dp(step-1, 1), dp(step-1, 0)) + wine[step-1])
                return res[eat][step]
            else:
                res[eat][step] = max(dp(step-1, 1), dp(step-1, 0))
                return res[eat][step]
        else:
            return res[eat][step]


n = int(input())
wine = []
maxWine = 0
for i in range(n):
    wine.append(int(input()))
res = [[-1] * 10001 for _ in range(2)]
print(max(dp(n, 0),dp(n, 1)))
print()



