#https://programmers.co.kr/learn/courses/30/lessons/42579
import pandas as pd
def solution(genres, plays):
    answer = []
    df = pd.DataFrame({'idx': [i for i in range(len(genres))], 'genres': genres, 'plays': plays})
    gen_order = df.groupby('genres').sum().reset_index().sort_values('plays', ascending=False).genres
    df = df.sort_values('plays', ascending=False).reset_index(drop=True).groupby('genres').head(2)
    for gen in gen_order:
        idxs = df.loc[df['genres'] == gen].idx
        answer.extend(idxs)

    return answer
