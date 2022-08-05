from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance

from est_membre import est_membre


def difference(list_a: List[str], list_b: List[str]) -> List[str]:
    if nil(list_b):
        return list_a
    elif nil(list_a):
        return []
    elif est_membre(list_b, head(list_a)):
        return difference(tail(list_a), list_b)
    else:
        return add(head(list_a), difference(tail(list_a), list_b))


if __name__ == "__main__":
    # assert difference([], []) == []
    # assert difference(['a'], []) == ['a']
    # assert difference([], ['a']) == []
    # assert difference(['a'], ['a']) == []
    # assert difference(['a','b'], ['b', 'a']) == []
    # assert difference(['a','b'], ['c', 'a']) == ['b']

    with open("./data/R20.txt", "w") as output_file:
        instances = read_instances("./data/T20.txt")
        output_file.write(f"{len(instances)}\n")

        for instance in instances:
            l1, l2 = split_instance(instance)
            l1, l2 = instance_as_list(l1), instance_as_list(l2)
            output_file.write(f"{list_as_str(difference(l1, l2))}\n")
