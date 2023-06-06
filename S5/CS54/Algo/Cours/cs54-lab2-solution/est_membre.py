from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances, split_instance


def est_membre(list: List[str], c: str) -> bool:
    if nil(list):
        return False
    elif head(list) == c:
        return True
    else:
        return est_membre(tail(list), c)


if __name__ == "__main__":
    # l = []
    # assert(est_membre(l, 'x') == False)
    # l = add('a', l)
    # assert(est_membre(l, 'x') == False)
    # assert(est_membre(l, 'a') == True)
    # l = add('b', l)
    # assert(est_membre(l, 'x') == False)
    # assert(est_membre(l, 'a') == True)
    # assert(est_membre(l, 'b') == True)

    with open("./data/R2.txt", "w") as output_file:
        instances = read_instances("./data/T2.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            c, l = split_instance(instance)
            c, l = c, instance_as_list(l)
            output_file.write(f"{est_membre(l, c)}\n")
