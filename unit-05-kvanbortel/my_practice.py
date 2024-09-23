"""
Author: Kayla Van Bortel
"""

import csv


def dict_stuff():
    a_dict = dict()
    with open("data/pokemon_cards.csv") as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        for record in csv_reader:
            name, num, type = record[0], record[1], record[2]
            a_dict[num] = (num, name, type)
        for key in a_dict:
            print(key, a_dict[key])


def hash_stuff(length, element):
    table = [[] for _ in range(length)]
    index = hash(element) % len(table)
    if element not in table[index]:
        table[index].append(element)
    return table


def main():
    dict_stuff()
    print(hash_stuff(5, 3))


if __name__ == "__main__":
    main()
