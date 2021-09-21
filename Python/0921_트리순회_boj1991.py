import sys
from collections import defaultdict

def preOrder(tree, curNode):
    if curNode == '.':
        return
    print(curNode, end = '')
    preOrder(tree, tree[curNode][0])
    preOrder(tree, tree[curNode][1])

def inOrder(tree, curNode):
    if curNode == '.':
        return
    inOrder(tree, tree[curNode][0])
    print(curNode, end = '')
    inOrder(tree, tree[curNode][1])

def postOrder(tree, curNode):
    if curNode == '.':
        return
    postOrder(tree, tree[curNode][0])
    postOrder(tree, tree[curNode][1])
    print(curNode, end = '')

N = int(sys.stdin.readline().rstrip())
tree = defaultdict(list)
isChild = defaultdict(int)
for i in range(N):
    r, lc, rc = sys.stdin.readline().split()
    tree[r] = [lc, rc]
    isChild[lc], isChild[rc] = 1, 1
    if isChild[r] == None:
        isChild[r] = 0

root = None
for node in sorted(list(tree.keys())):
    if isChild[node] == 0:
        root = node

preOrder(tree, root)
print()
inOrder(tree, root)
print()
postOrder(tree, root)