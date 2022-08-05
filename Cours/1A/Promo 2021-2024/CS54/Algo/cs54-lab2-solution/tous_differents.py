from typing import List
from cs54_list import nil, head, tail, add, instance_as_list
from cs54_tools import read_instances
from est_membre import est_membre


def tous_differents(list: List[str]) -> bool:
    if nil(list):
        return True
    elif est_membre(tail(list), head(list)):
        return False
    else:
        return tous_differents(tail(list))


if __name__ == "__main__":
    # l = []
    # assert(tous_differents(l) == True)
    # l = add('a', l)
    # assert(tous_differents(l) == True)
    # l = add('b', l)
    # assert(tous_differents(l) == True)
    # l = add('a', l)
    # assert(tous_differents(l) == False)

    with open("./data/R4.txt", "w") as output_file:
        instances = read_instances("./data/T4.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            l = instance_as_list(instance)
            output_file.write(f"{tous_differents(l)}\n")
