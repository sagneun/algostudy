# https://programmers.co.kr/learn/courses/30/lessons/42626

def heapify(array, cur_idx):
    if cur_idx <= 0:
        return array

    left_child = cur_idx * 2
    rigth_child = left_child + 1

    smallest_idx = cur_idx

    if (left_child < len(array)) and (array[left_child] < array[smallest_idx]):
            smallest_idx = left_child
    if (rigth_child < len(array)) and (array[rigth_child] < array[smallest_idx]):
            smallest_idx = rigth_child

    if smallest_idx != cur_idx:
        array[cur_idx], array[smallest_idx] = array[smallest_idx], array[cur_idx]
        array = heapify(array, smallest_idx)

    array = heapify(array, cur_idx-1)
    return array

def solution(scoville, K):
    answer = 0

    scoville_ = [0]
    scoville_.extend(scoville)

    while len(scoville_) > 1:
        min1, min2 = None, None
        if len(scoville_) > 1:
            scoville_ = heapify(scoville_, (len(scoville_) - 1) // 2)
            min1 = scoville_[1]
            scoville_.pop(1)

        if len(scoville_) > 1:
            scoville_ = heapify(scoville_, (len(scoville_) - 1) // 2)
            min2 = scoville_[1]
            scoville_.pop(1)

        if (min1 is None) or (min2 is None):
            return -1
        else:
            answer += 1
            if (min1 + min2 * 2) >= K:
                break
    return answer

