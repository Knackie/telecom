def main() -> None:
    """
    Ouvre E5.txt et écrit pour chaque de ses lignes (sauf la première) son minimum lexicographique
    dans R5.txt
    """
    with open("E5.txt", "r") as e5, open("R5.txt", "w") as r5:
        number_of_tests = e5.readline()
        r5.write(number_of_tests)

        for _ in range(int(number_of_tests)):
            data = r5.readline().strip().split(",")
            k = data[0]
            string = data[1]


if __name__ == "__main__":
    main()
