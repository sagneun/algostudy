# https://programmers.co.kr/learn/courses/30/lessons/42626
import heapq
def solution(scoville, K):
    answer = 0
    scov_heap = []

    for scov in scoville:
        heapq.heappush(scov_heap, scov)

    while scov_heap[0] < K:
        if len(scov_heap) < 2 :
            if scov_heap[0] < K:
                return -1
            break

        min1 = scov_heap[0]
        heapq.heappop(scov_heap)
        min2 = scov_heap[0]
        heapq.heappop(scov_heap)
        heapq.heappush(scov_heap, (min1 + min2 * 2))
        answer += 1

    return answer
