
# def solution(N, number):
#     arr = set()
#     answer = 0

#     def dp(n, N, number, arr):
#         if n == 1:
#             arr.add(N)
#         else:
#             temp = list(arr)
#             arr.add(int(str(N) * n))
#             for elem in temp:
#                 arr.add(elem + N)
#                 arr.add(elem - N)
#                 arr.add(N - elem)
#                 arr.add(elem * N)
#                 arr.add(elem // N)
#                 if elem != 0:
#                     arr.add(N // elem)

#         print(arr)
    
#     for i in range(1,9):
#         dp(i, N, number, arr)
#         if number in arr:
#             answer = i
#             break
#         else:
#             answer = -1
    
#     return answer

# print(solution(5,12))
# print(solution(2,11))
# print(solution(5,24))
# 5*5 - 5/5


#     # + - * /
#     # 55 10 0 25 1

#     # 555
#     # 60 50 275 11

def solution(N, number):
    answer = -1
    dp = [set() for _ in range(9)]

    i = 0
    chk = 0
    for i in range(1, 9):
        if i == 1:
            dp[i].add(N)
            if number in dp[i]:
                chk = 1
                break
        elif i == 2:
            # 55
            dp[i].add(int(f'{N}'*i))
            # 5op5
            elem = list(dp[i-1])[-1]
            temp = {elem+N, elem-N, elem*N, elem//N, N+elem, N-elem, N*elem, N//elem}
            dp[i] = dp[i].union(temp)
            if number in dp[i]:
                chk = 1
                break
        else:
            dp[i].add(int(f'{N}'*i))
            # i=7
            # 1~6 j=1   j=2   j=3
            # 6~1 i-j=6 i-j=5 i-j=4
            for j in range(1, i//2+1):
                for elem1 in dp[j]:
                    for elem2 in dp[i-j]:
                        if elem1 != 0 and elem2 != 0:
                            temp = {elem1+elem2, elem1-elem2, elem1*elem2, elem1//elem2, elem2-elem1, elem2//elem1}
                        elif elem1 == 0 and elem2 != 0:
                            temp = {elem1+elem2, elem1-elem2, elem1*elem2, elem1//elem2, elem2-elem1}
                        elif elem1 != 0 and elem2 ==0:
                            temp = {elem1+elem2, elem1-elem2, elem1*elem2, elem2-elem1, elem2//elem1}
                        else:
                            temp = {0}
                        dp[i] = dp[i].union(temp)
                        if number in dp[i]:
                            chk = 1
                            break                        
                    if chk:
                        break
                if chk:
                    break
            if chk:
                break

    if i <= 8 and chk:
        answer = i
    return answer
    
# print(solution(5, 12), 4)
# print(solution(2, 11), 3)
# print(solution(5, 13), 5)
# print(solution(8, 53), 5)
# print(solution(5, 5), 1)
# print(solution(5,12),4)
# print(solution(2,11),3)
# print(solution(5,5),1)
# print(solution(5,10),2)
# print(solution(5,31168),-1)
# print(solution(1,1121),7)
# print(solution(5,1010),7)
# print(solution(3,4),3)
# print(solution(5,5555),4) dffff
# print(solution(5,5550),5)
# print(solution(5,20),3)
# print(solution(5,30),3)
# print(solution(6,65),4)
# print(solution(5,2),3)
# print(solution(5,4),3)
# print(solution(1,1),1)
print(solution(1,11),2)
print(solution(1,111),3)
print(solution(1,1111),4)
print(solution(1,11111),5)
# print(solution(7,7776),6)
# print(solution(7,7784),5)
print(solution(2,22222),5)
# print(solution(2,22223),7)
# print(solution(2,22224),6)
# print(solution(2,11111),6)
# print(solution(2,11),3)
# print(solution(2,111),4)
# print(solution(2,1111),5)
# print(solution(9,36),4)
# print(solution(9,37),6)
# print(solution(9,72),3)
# print(solution(3,18),3)
# print(solution(2,1),2)
# print(solution(4,17),4)
# 1 - 5
# 2 - 55 5+5 5-5 5*5 5//5
# 3 - 5 +-*/ 55 5+5 5-5 5*5 5//5, 55 5+5 5-5 5*5 5//5 +-*/ 5
#     5-5+5 5-5-5 (5-5)*5 (5-5)//5 5//5+5 5//5-5 5//5*5 5//5//5
# 4 - 

# 1 2      3
# 5 1{}op5 