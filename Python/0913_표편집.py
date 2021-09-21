class Node:
    def __init__(self, data, prev, next):
        self.data = data
        self.prev = prev
        self.next = next

class LinkedList:
    def __init__(self, data):
        self.head = Node(data, None, None)
        self.tail = self.head
        self.curK = 0

    def append(self, data, k):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(data, cur, None)
        self.tail = cur.next

        if data == k:
            self.curK = self.tail

    def print(self):
        cur = self.head
        ret = ''
        while cur is not None:
            # print(cur.data)
            ret += str(cur.data)
            cur = cur.next
        return ret

    def insert(self, data):
        cur = self.head
        while cur is not self.tail and data > cur.data:
            cur = cur.next
        
        if cur is not self.head and cur is not self.tail:
            cur.prev.next = Node(data, cur.prev, cur)
            cur.prev = cur.prev.next
        elif cur is self.head:
            if data < cur.data:
                cur.prev = Node(data, None, cur)
                self.head = cur.prev
            else:
                cur.next.prev = Node(data, cur, cur.next)
                cur.next = cur.next.prev                
        elif cur is self.tail:
            if data < cur.data:
                cur.prev.next = Node(data, cur.prev, cur)
                cur.prev = cur.prev.next
            else:
                cur.next = Node(data, cur, None)
                self.tail = cur.next

    def delete(self, delStack):
        cur = self.head
        while cur is not self.curK:
            cur = cur.next
        
        delStack.append(self.curK.data)

        if self.curK is not self.head and self.curK is not self.tail:
            cur.prev.next = cur.next
            cur.next.prev = cur.prev
            self.curK = cur.next
        elif self.curK is self.head:
            cur.next.prev = None
            self.head = cur.next
            self.curK = cur.next
        elif self.curK is self.tail:
            cur.prev.next = None
            self.tail = cur.prev
            self.curK = cur.prev

    def movCurK(self, op, v):
        if op == 'D':
            while v > 0:
                v -= 1
                self.curK = self.curK.next
        elif op == 'U':
            while v > 0:
                v -= 1
                self.curK = self.curK.prev

def solution(n, k, cmd):
    answer = ['X'] * n
    table = LinkedList(0)
    for i in range(1, n):
        table.append(i, k)

    delStack = []
    for line in cmd:
        if line != 'C' and line != 'Z':
            op, v = line.split()
            v = int(v)
        else:
            op = line

        if op == 'D' or op == 'U':
            table.movCurK(op, v)            
        elif op == 'C':
            table.delete(delStack)
        elif op == 'Z':
            table.insert(delStack.pop())

    ret = table.print()
    for i in range(len(ret)):
        answer[int(ret[i])] = 'O'

    answer = ''.join(answer)
    return answer


print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]),"OOOOXOOO")
print(solution(8,2,["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]),"OOXOXOOO")
print(solution(5,2,["D 2", "C", "Z"]))