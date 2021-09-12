def solution(n, k, cmd):
    answer = ''
    status = [1] * n
    delStack = []

    for line in cmd:
        if line != 'C' and line != 'Z':
            op, v = line.split()
            v = int(v)
        else:
            op = line

        if op == 'D':
            while v > 0:
                if status[k] == 1:
                    v -= 1
                    k += 1
                else:
                    k += 1
        elif op == 'U':
            while v > 0:
                if status[k] == 1:
                    v -= 1
                    k -= 1
                else:
                    k -= 1
        elif op == 'C':
            status[k] = 0
            delStack.append(k)
            if k < n - 1:
                k += 1
            else:
                k -= 1
        elif op == 'Z':
            cz = delStack.pop()
            status[cz] = 1

    for i in range(n):
        if status[i] == 1:
            answer += 'O'
        else:
            answer += 'X'

    return answer


print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]),"OOOOXOOO")
print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]),"OOXOXOOO")