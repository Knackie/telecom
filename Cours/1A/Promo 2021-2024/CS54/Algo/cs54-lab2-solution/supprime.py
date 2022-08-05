from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances, split_instance


def supprime(list: List[str], c: str) -> List[str]:
    if nil(list):
        return list
    elif head(list) == c:
        return supprime(tail(list), c)
    else:
        return add(head(list), supprime(tail(list), c))


if __name__ == "__main__":
    # l = []
    # assert(nil(supprime(l, 'x')))
    # l = add('a', l)
    # assert(supprime(l, 'x') == [ 'a' ])
    # assert(nil(supprime(l, 'a')))
    # l = add('b', l)
    # assert(supprime(l, 'x') == [ 'b', 'a' ])
    # assert(supprime(l, 'a') == [ 'b' ])
    # assert(supprime(l, 'b') == [ 'a' ])

    with open("./data/R5.txt", "w") as output_file:
        instances = read_instances("./data/T5.txt")
        output_file.write(f"{len(instances)}\n")
        for instance in instances:
            c, l = split_instance(instance)
            c, l = c, instance_as_list(l)
            output_file.write(f"{list_as_str(supprime(l, c))}\n")
