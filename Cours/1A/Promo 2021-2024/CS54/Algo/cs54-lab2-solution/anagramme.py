from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance

from est_membre import est_membre
from supprime import supprime


def anagramme(list_a: List[str], list_b: List[str]) -> bool:
    if nil(list_a):
        if nil(list_b):
            return True
        else:
            return False
    elif est_membre(list_b, head(list_a)):
        return anagramme(tail(list_a), supprime(list_b, head(list_a)))
    else:
        return False


if __name__ == "__main__":
    # assert anagramme([], [])
    # assert anagramme(['a'], []) == False
    # assert anagramme([], ['a']) == False
    # assert anagramme(['a'], ['a'])
    # assert anagramme(['a','b'], ['b', 'a'])
    # assert anagramme(['a','b'], ['c', 'a']) == False
    # assert anagramme(['a','b','c'], ['b', 'c', 'a'])
    # assert anagramme(['a','b','c'], ['a', 'b', 'c'])
    # assert anagramme(['a','b','c'], ['c', 'b', 'a'])

    with open("./data/R18.txt", "w") as output_file:
        instances = read_instances("./data/T18.txt")
        output_file.write(f"{len(instances)}\n")

        for instance in instances:
            l1, l2 = split_instance(instance)
            l1, l2 = instance_as_list(l1), instance_as_list(l2)
            output_file.write(f"{anagramme(l1, l2)}\n")
