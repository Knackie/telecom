from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance

from dernier import dernier
from sauf_dernier import sauf_dernier


def retourne(list: List[str]) -> List[str]:
    if nil(list):
        return list
    return add(dernier(list), retourne(sauf_dernier(list)))


def retourne_helper(list_todo: List[str], list_done: List[str]) -> List[str]:
    if nil(list_todo):
        return list_done
    else:
        return retourne_helper(tail(list_todo), add(head(list_todo), list_done))


def retourne_v2(list: List[str]) -> List[str]:
    return retourne_helper(list, [])


if __name__ == "__main__":
    # l = []
    # assert(nil(retourne(l)))
    # l = add('a', l)
    # assert(retourne(l) == l)
    # l = add('b', l)
    # assert(retourne(l) == [ 'a', 'b' ])
    # l = add('c', l)
    # assert(retourne(l) == [ 'a', 'b', 'c' ])

    with open("./data/R12.txt", "w") as output_file:
        instances = read_instances("./data/T12.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)

            assert retourne(l) == retourne_v2(l)

            output_file.write(f"{list_as_str(retourne(l))}\n")
