# https://programmers.co.kr/learn/courses/30/lessons/43162
import numpy as np

def dfs(n, computers, cur_idx, visited, line):
    if visited[cur_idx] != 0:
        return visited
    else:
        visited[cur_idx] = line
        to_visit = [idx for idx in range(n) if (computers[cur_idx, idx] == 1) and (cur_idx != idx) and (visited[idx] == 0)]
        for idx in to_visit:
            visited = dfs(n, computers, idx, visited, line)
        return visited

def solution(n, computers):
    computer_visit = np.array([0] * n)
    np_computers = np.array(computers)

    for computer_idx in range(n):
        computer_visit = dfs(n, np_computers, computer_idx, computer_visit, computer_idx+1)

    answer = len(np.unique(computer_visit))
    return answer
