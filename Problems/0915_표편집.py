from collections import defaultdict

def solution(n, k, cmd):
    answer = ''
    
    linkedList = {i: [i-1, i+1] for i in range(n)}
    delNode = []

    for op in cmd:
        op = op.split()
        
        if op[0] == 'U':
            v = int(op[1])
            while v > 0:
                v -= 1
                k = linkedList[k][0]
        elif op[0] == 'D':
            v = int(op[1])
            while v > 0:
                v -= 1
                k = linkedList[k][1]
        elif op[0] == 'C':
            prev = linkedList[k][0]
            next = linkedList[k][1]
            if prev != -1:
                linkedList[prev][1] = next
            if next != n:
                linkedList[next][0] = prev

            delNode.append([k, linkedList[k]])
            del linkedList[k]

            if next == n:
                # 마지막 노드 삭제 시 커서는 새로운 마지막 노드로
                k = prev
            else:
                k = next

        else:
            curNode, links = delNode.pop()
            prev, next = links

            linkedList[curNode] =[prev, next]
            if prev != -1:
                linkedList[prev][1] = curNode
            if next != n:
                linkedList[next][0] = curNode

    for i in range(n):
        if linkedList.get(i):
            answer += 'O'
        else:
            answer += 'X'

    return answer

print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]),"OOOOXOOO")
print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]),"OOXOXOOO")
print(solution(8,2,["D 2","C","U 3","C","D 4","C","C","U 2","Z","Z","U 1","C"]))