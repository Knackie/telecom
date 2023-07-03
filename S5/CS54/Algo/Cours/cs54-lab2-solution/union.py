from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance

from est_membre import est_membre


def union(list_a: List[str], list_b: List[str]) -> List[str]:
    if nil(list_a):
        if nil(list_b):
            return []
        else:
            return union(list_b, [])
    elif est_membre(tail(list_a), head(list_a)) or est_membre(list_b, head(list_a)):
        return union(tail(list_a), list_b)
    else:
        return add(head(list_a), union(tail(list_a), list_b))


if __name__ == "__main__":
    # assert union([], []) == []
    # assert union(['a'], []) == ['a']
    # assert union([], ['a']) == ['a']
    # assert union(['a'], ['a']) == ['a']
    # assert union(['a','b'], ['b', 'a']) == ['b', 'a']
    # assert union(['a','b'], ['c', 'a']) == ['b', 'c', 'a']

    with open("./data/R19.txt", "w") as output_file:
        instances = read_instances("./data/T19.txt")
        output_file.write(f"{len(instances)}\n")

        for instance in instances:
            l1, l2 = split_instance(instance)
            l1, l2 = instance_as_list(l1), instance_as_list(l2)
            output_file.write(f"{list_as_str(union(l1, l2))}\n")
