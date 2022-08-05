from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, split_instance


def occurrence(c: str, list: List[str]) -> int:
    if nil(list):
        return 0
    elif head(list) == c:
        return 1 + occurrence(c, tail(list))
    else:
        return 0 + occurrence(c, tail(list))


if __name__ == "__main__":
    # l = []
    # assert(occurrence('a', l) == 0)
    # l = add('a', l)
    # assert(occurrence('x', l) == 0)
    # assert(occurrence('a', l) == 1)
    # l = add('b', l)
    # assert(occurrence('x', l) == 0)
    # assert(occurrence('a', l) == 1)
    # assert(occurrence('b', l) == 1)
    # l = add('a', l)
    # assert(occurrence('x', l) == 0)
    # assert(occurrence('a', l) == 2)
    # assert(occurrence('b', l) == 1)

    with open("./data/R3.txt", "w") as output_file:
        instances = read_instances("./data/T3.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            c, l = split_instance(instance)
            c, l = c, instance_as_list(l)
            output_file.write(f"{occurrence(c, l)}\n")
