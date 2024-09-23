"""
This program uses sets and dictionaries to find pokedex data
Author: Kayla Van Bortel
"""

import csv
import random

MAX_CARDS = 102


def make_database(filename):
    """
    Adds all of the cards as tuples into a database dictionary
    """
    database = dict()
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        for record in csv_reader:
            name, num, type = record[0], record[1], record[2]
            database[int(num)] = (int(num), name, type)
    return database


def make_pack(database):
    """
    Create a pack of a random 10 cards from the database
    """
    pack = set()
    while len(pack) < 10:
        num = random.randint(1, MAX_CARDS)
        pack.add(database[num])
    return pack


def build_basic_collection(database):
    """
    Counts how many 10-packs to add until complete collection is obtained
    """
    collection = set()
    count = 0
    while len(collection) < 102:
        count += 1
        for card in make_pack(database):
            collection.add(card)
    return count


def build_counting_collection(database):
    """
    Counts how many of each card were purchased until complete collection
    """
    extras = [[] for _ in range(102)]
    collection = set()
    while len(collection) < 102:
        for card in make_pack(database):
            if card in collection:
                num = card[0]
                extras[num - 1].append(num)
            collection.add(card)
    return collection, extras


def main():
    database = make_database("data/pokemon_cards.csv")
    print("Cards in database:", len(database))
    print("Cards in pack:")
    pack = make_pack(database)
    for card in pack:
        print(" ", card)

    total = 0
    for _ in range(1000):
        total += build_basic_collection(database)
    print("Average cards purchased to complete set:", total / 1000)

    print("Cards purchased to complete set:")
    collection, extras = build_counting_collection(database)
    sorted_collection = sorted(collection)
    for card in range(len(sorted_collection)):
        print(sorted_collection[card], ": ", len(extras[card]) + 1, sep="")  # add 1 for the card that was not an extra

    max = 0
    max_card = 0
    for card in range(len(extras)):
        length = len(extras[card]) + 1
        if length > max:
            max = length
            max_card = card
    print("Most: ", sorted_collection[max_card], ": ", max, sep="")

    total = 0
    for card in range(len(extras)):
        total += len(extras[card]) + 1  # add 1 for the card that was not an extra
    print("Total:", total)


if __name__ == "__main__":
    main()
