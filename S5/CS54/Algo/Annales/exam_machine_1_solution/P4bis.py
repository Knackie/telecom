def main() -> None:
    """
    Ouvre E4bis.txt et écrit pour chaque ligne sa traduction langage normal dans R4bis.txt
    """
    with open("E4bis.txt", "r") as e4bis, open("R4bis.txt", "w") as r4bis:
        number_of_tests = e4bis.readline()
        r4bis.write(number_of_tests)

        for _ in range(int(number_of_tests)):
            # on peut le strip car il n'y a aucun sens à des espaces de début et de fin en e9
            line_as_e9 = e4bis.readline().strip()
            line = ""

            i = 0
            while i < len(line_as_e9):
                repetition = 1

                if line_as_e9[i] == "0":
                    line += " "
                elif line_as_e9[i] != " ":

                    if i + 1 < len(line_as_e9) and line_as_e9[i + 1] == line_as_e9[i]:
                        repetition += 1
                        if i + 2 < len(line_as_e9) and line_as_e9[i + 2] == line_as_e9[i]:
                            repetition += 1
                            if i + 3 < len(line_as_e9) and line_as_e9[i + 3] == line_as_e9[i]:
                                repetition += 1

                    line += e9_to_normal(line_as_e9[i], repetition)

                i += repetition

            r4bis.write(line)
            r4bis.write("\n")


def e9_to_normal(number: str, repetition: int) -> str:
    """
    Traduit une lettre en e9 vers sa représentation alphabétique

    :param number: représentation du caractère en e9
    :param repetition: nombre de fois où le caractère est répété en e9, entre 1 et 4
    :return: la lettre qui était codé en e9, un unique caractère
    """
    if number in "23456":
        return chr(97 + (int(number) - 2) * 3 + repetition - 1)
    elif number == "7":
        return chr(ord("p") + repetition - 1)
    elif number == "8":
        return chr(ord("t") + repetition - 1)
    else:
        # 9
        return chr(ord("w") + repetition - 1)


if __name__ == "__main__":
    main()
