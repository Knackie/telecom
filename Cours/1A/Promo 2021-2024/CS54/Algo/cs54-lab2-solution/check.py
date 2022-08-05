#!/usr/bin/env python3

from os import path, system

import colorama
from colorama import Fore, Back, Style

colorama.init()

questions = [
    "longueur",
    "est_membre",
    "occurrence",
    "tous_differents",
    "supprime",
    "deuxieme",
    "dernier",
    "sauf_dernier",
    "nieme",
    "npremiers",
    "nderniers",
    "retourne",
    "concat",
    "min_ch",
    "croissante",
    "nnaturels",
    "palindrome",
    "anagramme",
    "union",
    "difference",
]

for num, question_title in enumerate(questions, start=1):
    filename = f"{question_title}.py"
    answer_filename = f"./data/R{num}.txt"
    expected_answer_filename = f"./data/E{num}.txt"

    print(f"{Style.BRIGHT}Question {num}{Style.RESET_ALL}{Fore.RESET}")

    if path.isfile(filename):
        print(f" - {Style.BRIGHT}{filename}{Style.NORMAL} exists{Fore.RESET}")
    else:
        print(f" - {Fore.RED}{Style.BRIGHT}{filename}{Style.NORMAL} is missing{Fore.RESET}")
        continue

    system(f"python {filename}")

    if path.isfile(answer_filename):
        print(f" - {Style.BRIGHT}{answer_filename}{Style.NORMAL} exists{Fore.RESET}")
    else:
        print(f" - {Fore.RED}{Style.BRIGHT}{answer_filename}{Style.NORMAL} is missing{Fore.RESET}")
        continue

    status = system(f"diff --brief {expected_answer_filename} {answer_filename} > /dev/null")
    if status == 0:
        print(f" - {Fore.GREEN}{Style.BRIGHT}success!{Style.NORMAL}{Fore.RESET}")
    else:
        print(f" - {Fore.RED}{Style.BRIGHT}error{Style.NORMAL} -- check your program{Fore.RESET}")
        continue
