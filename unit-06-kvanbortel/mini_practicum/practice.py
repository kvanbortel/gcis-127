"""
Author: Kayla Van Bortel
"""


def letters():
    letters = set()
    for each in range(ord("a"), ord("z") + 1):
        letters.add(chr(each))
    return letters


def make_letter_frequency(filename):
    d_letters = dict()
    for letter in letters():
        d_letters[letter] = 0
    with open(filename) as file:
        for line in file:
            line = line.lower().strip()
            words = line.split()
            for word in words:
                for chr in word:
                    if chr in letters():
                        for key in d_letters:
                            if key == chr:
                                value = d_letters[key]
                                d_letters[key] = value + 1
    return d_letters


def print_letter_frequency(dictionary):
    for key in dictionary:
        value = dictionary[key]
        print(key, ":", value)
    max = 0
    max_letter = 0
    for key in dictionary:
        value = dictionary[key]
        if value > max:
            max = value
            max_letter = key
    print("The most populat letter:", max_letter, ":", max)


def main():
    d_letters = make_letter_frequency("data/alice.txt")
    print_letter_frequency(d_letters)

    d_letters = make_letter_frequency("data/rit_mission.txt")
    print_letter_frequency(d_letters)


if __name__ == "__main__":
    main()
