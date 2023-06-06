def main() -> None:
    """
    Ouvre E3.txt et écrit l'année où il y a eu le plus de personnes vivantes dans R3.txt
    """
    FIRST_YEAR_TO_CONSIDER = 1900
    LAST_YEAR_TO_CONSIDER = 2000

    with open("E3.txt", "r") as e3, open("R3.txt", "w") as r3:
        # 2000 est inclus donc une tranche de 101 ans
        years = [
            0 for i in range(
                FIRST_YEAR_TO_CONSIDER, LAST_YEAR_TO_CONSIDER + 1)
        ]

        number_of_inhabitant = e3.readline()

        for _ in range(int(number_of_inhabitant)):
            data = e3.readline().split(",")
            year_of_birth = int(data[0])
            year_of_death = int(data[1])
            for i in range(year_of_birth, year_of_death + 1):
                years[i - FIRST_YEAR_TO_CONSIDER] += 1

        index_of_max = 0
        for i in range(1, len(years)):
            if years[i] > years[index_of_max]:
                index_of_max = i

        r3.write(str(FIRST_YEAR_TO_CONSIDER + index_of_max))


if __name__ == "__main__":
    main()
