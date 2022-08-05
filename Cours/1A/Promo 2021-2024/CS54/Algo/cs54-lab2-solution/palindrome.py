from typing import List
from cs54_list import nil, head, tail, add, instance_as_list, list_as_str
from cs54_tools import read_instances

from dernier import dernier
from sauf_dernier import sauf_dernier


def palindrome(list: List[str]) -> bool:
    if nil(list):
        return True
    elif nil(tail(list)):
        return True
    elif head(list) != dernier(list):
        return False
    else:
        return palindrome(sauf_dernier(tail(list)))


if __name__ == "__main__":
    # assert palindrome([])
    # assert palindrome(['a'])
    # assert palindrome(['a', 'a'])
    # assert palindrome(['a', 'b']) == False
    # assert palindrome(['a', 'b', 'a']) == True
    # assert palindrome(['a', 'b', 'b', 'a']) == True
    # assert palindrome(['a', 'b', 'c', 'b', 'a']) == True

    with open("./data/R17.txt", "w") as output_file:
        instances = read_instances("./data/T17.txt")
        output_file.write(f"{len(instances)}\n")
        for num, instance in enumerate(instances, start=1):
            if num >= 4:
                instance = instance.replace(" ", "").replace(",", "").replace("?", "").replace("!", "").lower()

            l = instance_as_list(instance)
            output_file.write(f"{palindrome(l)}\n")
