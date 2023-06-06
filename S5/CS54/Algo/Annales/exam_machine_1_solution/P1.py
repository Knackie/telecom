def main() -> None:
    """
    Ouvre E1.txt et écrit pour chaque de ses lignes (sauf la première) son indice Hisch correspondant dans R1.txt
    """
    with open("E1.txt", "r") as e1, open("R1.txt", "w") as r1:
        number_of_tests = e1.readline()
        r1.write(number_of_tests)

        for _ in range(int(number_of_tests)):
            list_of_number_of_citation = [
                int(line_element)
                for line_element in e1.readline().split(",")
            ]
            r1.write(str(compute_hirsch(list_of_number_of_citation)))
            r1.write("\n")


def compute_hirsch(list_of_number_of_citation: list[int]) -> int:
    """
    :param list_of_number_of_citation: liste du nombre de citations par article
    :returns: l'indice Hisch correspondant
    """
    actual_hirsch = 0
    while is_hisrch_valid(actual_hirsch, list_of_number_of_citation):
        actual_hirsch += 1

    return actual_hirsch - 1  # -1 car on veut le dernier valide


def is_hisrch_valid(hirsch: int, list_of_number_of_citation: list[int]) -> bool:
    """
    :param hirsch:
    :returns: s'il y a au moins <hirsch> éléments de <list_of_number_of_citation> supérieurs ou égals à <hirsch>
    """
    number_of_valid = 0
    i = 0
    while i < len(list_of_number_of_citation) and number_of_valid < hirsch:
        if list_of_number_of_citation[i] >= hirsch:
            number_of_valid += 1
        i += 1

    return number_of_valid == hirsch


if __name__ == "__main__":
    main()
