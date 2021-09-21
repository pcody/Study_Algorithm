
def solution(phone_book):
    answer = True
    phone_book.sort()
    n = len(phone_book)
    # print(phone_book)

    for i in range(1, n):
        m = len(phone_book[i-1])
        if phone_book[i-1] in phone_book[i][:m]:
            answer = False
            return answer

    return answer

print(solution(["119","97674223","1195524421"]),False)
print(solution(["123","456","789"]),True)
print(solution(["12","123","1235","567","88"]),False)
print(solution(["2","32"]), True)
print(solution(["113333","115555","345555","555555", "345444"]), True)
print(solution(["1234", "1235", "567"]), True)
print(solution(["112","44","4544"]), True)
print(solution(["113333","115555","345555","555555", "345444","345444553"]), False)