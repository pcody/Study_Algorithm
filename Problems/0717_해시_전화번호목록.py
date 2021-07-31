## 시간초과 3,4번.. 눈물나네

# def solution(phone_book):
#     answer = True
#     N = len(phone_book)
#     #phone_book = list(zip(list(map(len, phone_book)),phone_book))
#     #phone_book.sort(key = lambda x : (x[0], x[1]))
#     #_, phone_book = zip(*phone_book)
#     phone_book.sort()
    
#     for j in range(N):
#         M = len(phone_book[j])
#         for i in range(N):
#             O = len(phone_book[i])
#             if j == i or phone_book[i][0] != phone_book[j][0] or M > O:
#                 continue
#             else:
#                 if phone_book[j] in phone_book[i][:M]:
#                     return False
                    
#     return answer

# def solution(phone_book):
#     answer = True
#     N = len(phone_book)
#     phone_book.sort()
    
#     # print(phone_book)
#     for j in range(N):
#         M = len(phone_book[j])
#         for i in range(j+1,N):
#             O = len(phone_book[i])
#             # if j == i or phone_book[i][0] != phone_book[j][0] or M > O:
#             #     continue
#             # else:
#                 # if phone_book[j] == phone_book[i][:M]:
#                 #     return False
#             chk = 1
#             for k in range(min(M, O)):
#                 if phone_book[j][k] != phone_book[i][k]:
#                     chk = 0
#                     break
#             if chk == 1:
#                 return False
#     return answer

# 복습하고 업로드하자
def solution(phone_book):
    answer = True
    N = len(phone_book)
    phone_book.sort()
    
    # print(phone_book)
    for j in range(N-1):
        M = len(phone_book[j])
        # for i in range(j+1,N):
        O = len(phone_book[j+1])
        chk = 1
        for k in range(min(M, O)):
            if phone_book[j][k] != phone_book[j+1][k]:
                chk = 0
                break
        if chk == 1:
            return False
        # else:
        #     break
    return answer

print(solution(["119", "97674223", "1195524421"]), "False")
print(solution(["123","456","789"]), "True")
print(solution(["12","123","1235","567","88"]), "False")
print(solution(["1234", "1235", "567"]), "True")
print(solution(["113333","115555","345555","555555", "345444"]), "True")
print(solution(["113", "44", "4544"]), "True")
print(solution(["987987","87"]), "True")