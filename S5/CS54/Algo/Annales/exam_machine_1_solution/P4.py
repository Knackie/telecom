def main() -> None:
    """
    Ouvre E4.txt et écrit pour chaque ligne sa traduction en E9 dans R4.txt
    """
    with open("E4.txt", "r") as e4, open("R4.txt", "w") as r4:
        number_of_tests = e4.readline()
        r4.write(number_of_tests)

        for _ in range(int(number_of_tests)):
            # on ne le strip pas pour enlever que le \n et pas des éventuels espaces de fin qu'on voudrait garder
            line = e4.readline().removesuffix("\n")
            line_as_e9 = ""
            for char in line:
                if char == " ":
                    line_as_e9 += "0"
                else:
                    next_char_in_e9 = translate_to_e9(char)
                    if len(line_as_e9) != 0 and next_char_in_e9[0] == line_as_e9[-1]:
                        line_as_e9 += " "
                    line_as_e9 += next_char_in_e9

            r4.write(line_as_e9)
            r4.write("\n")


def translate_to_e9(char: str) -> str:
    """
    Traduit le caractère donné en E9.
    On ne peut pas juste faire str(2 + (ord(char) - 97) // 3) * (1 + (ord(char) - 97) % 3)
    car certaines touches comportent 4 caratères (7 et 9)

    :param char: caractère à traduire
    :returns: la traduction, une chaine de caractères numériques de longueur entre 1 et 4
    """
    if char < "s":
        next_char_in_e9_solo = str(2 + (ord(char) - 97) // 3)
        number_of_repetitions = 1 + (ord(char) - 97) % 3
        return next_char_in_e9_solo * number_of_repetitions
    elif char == "s":
        return "7777"
    elif "s" < char < "z":
        next_char_in_e9_solo = str(3 + (ord(char) - 97 - 4) // 3)
        number_of_repetitions = 1 + (ord(char) - 97 - 4) % 3
        return next_char_in_e9_solo * number_of_repetitions
    else:
        return "9999"


if __name__ == "__main__":
    main()
