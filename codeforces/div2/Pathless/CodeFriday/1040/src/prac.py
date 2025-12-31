import sys

# Fast I/O helpers (lambda-based)
input = lambda: sys.stdin.readline().strip()
II = lambda: int(input())
MI = lambda: input().split()
LII = lambda: list(map(int, MI()))


def solve():
    n = II()
    v = []
    # Robustly read exactly n integers (they may span multiple lines)
    while len(v) < n:
        v.extend(LII())
    v = v[:n]

    s = sum(v)
    z = sum(1 for x in v if x == 0)
    return s + z


def main():
    t = II()
    out = []
    for _ in range(t):
        out.append(str(solve()))
    sys.stdout.write("\n".join(out) + "\n")


if __name__ == "__main__":
    main()