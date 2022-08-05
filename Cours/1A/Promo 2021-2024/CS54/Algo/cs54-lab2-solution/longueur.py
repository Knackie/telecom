from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances


def longueur(list: List[str]) -> int:
    if nil(list):
        return 0
    else:
        return 1 + longueur(tail(list))


if __name__ == "__main__":
    # l = []
    # assert(longueur(l) == 0)
    # l = add('a', l)
    # assert(longueur(l) == 1)
    # l = add('b', l)
    # assert(longueur(l) == 2)
    # l = add('c', l)
    # assert(longueur(l) == 3)

    with open("./data/R1.txt", "w") as output_file:
        instances = read_instances("./data/T1.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{longueur(l)}\n")
