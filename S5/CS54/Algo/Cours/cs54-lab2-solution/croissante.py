from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances


def croissante(list: List[str]) -> bool:
    if nil(list) or nil(tail(list)):
        return True
    elif head(list) > head(tail(list)):
        return False
    else:
        return croissante(tail(list))


if __name__ == "__main__":
    # l = []
    # assert croissante(l)
    # l = add('b', l)
    # assert croissante(l)
    # l = add('a', l)
    # assert croissante(l)
    # l = add('c', l)
    # assert croissante(l) == False

    with open("./data/R15.txt", "w") as output_file:
        instances = read_instances("./data/T15.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{croissante(l)}\n")
