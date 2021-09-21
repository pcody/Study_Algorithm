import sys

def binary(K, N, WLANs):
    answer = 0

    WLANs.sort()
    
    l, r = 1, WLANs[-1]
    while l <= r:
        mid = (l + r) // 2
        S = 0
        
        for WLAN in WLANs:
            S += WLAN // mid
        
        if S < N:
            r = mid - 1
        else:
            l = mid + 1
            answer = mid
    
    return answer

K, N = map(int, sys.stdin.readline().split())
WLANs = []
for _ in range(K):
    WLANs.append(int(sys.stdin.readline().rstrip()))

print(binary(K, N, WLANs))