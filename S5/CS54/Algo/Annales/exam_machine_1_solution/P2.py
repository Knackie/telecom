from typing import Union


def main() -> None:
    """
    Ouvre E2.txt et écrit pour chaque de ses lignes (sauf la première) la fenêtre des indices à trier pour
    que la ligne soit triée (de la forme "(a,b)" où <a> et <b> des entiers, ou -1 si la liste est triée) dans R2.txt
    """
    with open("E2.txt", "r") as e2, open("R2.txt", "w") as r2:
        number_of_tests = e2.readline()
        r2.write(number_of_tests)

        for _ in range(int(number_of_tests)):
            list_to_use = [
                int(line_element)
                for line_element in e2.readline().split(",")
            ]
            sorting_window = compute_sorting_window(list_to_use)
            r2.write(
                "%i,%i\n"
                %
                (sorting_window[0], sorting_window[1])
            )


def compute_sorting_window(list_to_use: list[int]) -> Union[tuple[int, int], int]:
    """
    :param list_to_use: liste non ordonnée d'entiers
    :returns: la borne inférieure et supérieure de la fenêtre des indices à trier pour
        que la liste soit triée, -1 si la liste est triée (c'est pas beau pour les types mais c'est ce qui est demandé)
    """
    i = 0
    first_misplaced_index = 0

    while i < len(list_to_use) and is_value_at_index_the_min_of_the_following(i, list_to_use):
        i += 1

    if i == len(list_to_use):
        return -1  # la liste est triée

    # sinon

    # il y a plus optimisé, je reviendrai dessus si j'ai le temps
    first_misplaced_index = i

    i = len(list_to_use) - 1
    while i > first_misplaced_index and is_value_index_at_the_max_of_before(i, list_to_use):
        i -= 1

    return (first_misplaced_index, i)


def is_value_at_index_the_min_of_the_following(index: int, list_to_use: list[int]) -> bool:
    """
    Fonction pour avoir quelque chose de plus opti qu'un <if list_to_use[index] == min(list_to_use[index:])>, car ça évite
    de parcourir tous les indices si False puisqu'on s'arrête au premier faux et de split la liste

    :param index: indice à utiliser
    :param list_to_use: liste d'entiers non triée
    :returns: si l'élément à l'index donné est le plus petit de la liste où les indices lui sont supérieurs
        (si d'autres sont lui sont égaux True aussi).
    """
    i = index
    while i < len(list_to_use) and list_to_use[index] <= list_to_use[i]:
        i += 1

    return i == len(list_to_use)


def is_value_index_at_the_max_of_before(index: int, list_to_use: list[int]) -> bool:
    """
    Fonction pour avoir quelque chose de plus opti qu'un <if list_to_use[index] == max(list_to_use[:index])>, car ça évite
    de parcourir tous les indices si False puisqu'on s'arrête au premier faux et de split la liste

    :param index: indice à utiliser
    :param list_to_use: liste d'entiers non triée
    :returns: si l'élément à l'index donné est le plus grand de la liste où les indices lui sont inférieurs
        (si d'autres sont lui sont égaux True aussi).
    """
    i = index - 1
    while i > 0 and list_to_use[i] <= list_to_use[index]:
        i -= 1

    return i == 0


if __name__ == "__main__":
    main()
