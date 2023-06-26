import collections
import sys
import heapq
temp_list = []
query = []
for line in sys.stdin:
    if not temp_list:
        temp_list.append(line.strip())
    elif not query:
        query.append(line.strip())
    elif len(query) == 1:
        query.append(line.strip())
        break
exchange_list = []
for i in temp_list[0].split(";"):
    exchange_list.append(i.split(","))

graph = collections.defaultdict(dict)
for i in exchange_list:
    x, y, v = i[0], i[1], float(i[2])
    graph[x][y] = 1 / v
    graph[y][x] = v

start = query[0]
end = query[1]
n = len(graph)
heap = [(1.0, start, n + 1)]
visited = collections.defaultdict(int)
result = []
while heap:
    cost, x, n = heapq.heappop(heap)
    if x == end:
        result.append(1 / cost)
    if visited[x] >= n:
        continue
    visited[x] = n
    for y, d_cost in graph[x].items():
        heapq.heappush(heap, (cost * d_cost, y, n - 1))

if result == []:
    print(-1.0)
else:
    print(max(result))










