# 계단 오르기

### 재귀는 시간초과
# def stepup(s):
#     global score, next, visited, sum, S, max;
#     if s == S:
#         if max < sum:
#             max = sum;
#         return;
#     if s > S:
#         return;
#     for i in next:
#         if i == 1 and visited[s - 1] == 1:
#             continue;
#         if s + i <= S:
#             if visited[s + i] == 0:
#                 visited[s + i] = 1;
#                 sum += score[s + i];
#                 stepup(s + i);
#                 visited[s + i] = 0;
#                 sum -= score[s + i];
#
# S = int(input());
# score = [0];
# next = [1, 2];
# visited = [0] * (S + 1);
# sum = 0;
# max = 0;
# for _ in range(S):
#     score.append(int(input()));
#
# stepup(0);
# print(max);

## DP Top Down
def dp(n):
    global score, res; # if n == 0일때 하고 n==3합치기
    if n == 1:
        res[n] = score[0];
        return res[n];
    elif n == 2:
        res[n] = score[0] + score[1];
        return res[n];
    elif n == 3:
        tmp1 = score[0] + score[2];
        tmp2 = score[1] + score[2];
        if tmp1 > tmp2:
            res[n] = tmp1;
        else:
            res[n] = tmp2;
        return res[n];
    else:
        if res[n] == -1:
            tmp1 = dp(n - 2) + score[n - 1];
            tmp2 = dp(n - 3) + score[n - 2] + score[n - 1];
            if tmp1 > tmp2:
                res[n] = tmp1;
            else:
                res[n] = tmp2;
        return res[n];

n = int(input());
score = [];
res = [-1] * (n + 1);
for _ in range(n):
    score.append(int(input()));
print(dp(n));

# DP Bottom Up
def dp(n):
    global score, res;
    if n == 1:
        res[1] = score[0];
    elif n == 2:
        res[2] = score[0] + score[1];
    elif n == 3:
        tmp1 = score[0] + score[2];
        tmp2 = score[1] + score[2];
        if tmp1 > tmp2:
            res[3] = tmp1;
        else:
            res[3] = tmp2;
    else:
        res[1] = score[0];
        res[2] = score[0] + score[1];
        tmp1 = score[0] + score[2];
        tmp2 = score[1] + score[2];
        if tmp1 > tmp2:
            res[3] = tmp1;
        else:
            res[3] = tmp2;

        for i in range(4, n + 1):
            if res[i] == -1:
                tmp1 = res[i - 2] + score[i - 1];
                tmp2 = res[i - 3] + score[i - 2] + score[i - 1];
                if tmp1 > tmp2:
                    res[i] = tmp1;
                else:
                    res[i] = tmp2;
    return res[n];

n = int(input());
score = [];
res = [-1] * (n + 1);
for _ in range(n):
    score.append(int(input()));
print(dp(n));