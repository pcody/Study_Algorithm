# def dp(n):
#     global wine, res;
#     if n == 1:
#         if res[n] == -1:
#             res[1] = wine[0];
#         return res[1];
#     elif n == 2:
#         if res[n] == -1:
#             res[1] = wine[0];
#             res[2] = wine[0] + wine[1];
#         return res[2];
#     elif n == 3:
#         if res[n] == -1:
#             res[1] = wine[0];
#             res[2] = wine[0] + wine[1];
#             tmp1 = wine[0] + wine[2];
#             tmp2 = wine[1] + wine[2];
#             if tmp1 > tmp2:
#                 res[3] = tmp1;
#             else:
#                 res[3] = tmp2;
#         return res[n];
#     else:
#         for i in range(4, n + 1):
#             if res[i] == -1:
#                 tmp1 = dp(i - 2) + wine[i - 1];
#                 tmp2 = dp(i - 3) + wine[i - 2] + wine[i - 1];
#                 if tmp1 > tmp2:
#                     res[i] = tmp1;
#                 else:
#                     res[i] = tmp2;
#         return res[n];

def dp(n):
    global res, wine;
    for i in range(1, n + 1):
        if i == 1:
            if res[i] == -1:
                res[i] = wine[0];
        elif i == 2:
            if res[i] == -1:
                res[i] = wine[0] + wine[1];
        elif i == 3:
            if res[i] == -1:
                tmp1 = wine[0] + wine[2];
                tmp2 = wine[1] + wine[2];
                if tmp1 > tmp2:
                    res[i] = tmp1;
                else:
                    res[i] = tmp2;
        else:
            if res[i] == -1:
                tmp1 = res[i - 2] + wine[i - 1];
                tmp2 = res[i - 3] + wine[i - 2] + wine[i - 1];
                if tmp1 > tmp2:
                    res[i] = tmp1;
                else:
                    res[i] = tmp2;
                if i > 4:
                    tmp3 = res[i - 4] + wine[i - 2] + wine[i - 1];
                    if res[i] < tmp3:
                        res[i] = tmp3;

n = int(input());
res = [-1] * (n + 1);
wine = [];
for _ in range(n):
    wine.append(int(input()));
dp(n)
# print(res);
print(max(res));

# 반례
# 7
# 100
# 400
# 200
# 2
# 1
# 400
# 200