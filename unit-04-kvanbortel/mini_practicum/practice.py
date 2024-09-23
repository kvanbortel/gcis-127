"""
Author: Kayla Van Bortel
"""

import re


def find_rabbit(filename):
    """
    Finds instances of "rabbit" in a text file
    """
    words = []
    count = 0
    with open(filename) as file:
        for line in file:
            line.strip()
            words = line.split()
            # print(words)
            for each in words:
                lower = each.lower()
                for _ in re.findall("rabbit", lower):
                    count = count + 1
    return count


def power(base, exponent):
    """
    Calculates powers
    """
    if exponent < 0:
        return None
    if exponent == 0:
        return 1
    if exponent == 1:
        return base
    if exponent % 2 != 0:
        return base * power(base, exponent // 2) * power(base, exponent // 2)
    if exponent % 2 == 0:
        return power(base, exponent // 2) * power(base, exponent // 2)


def main():
    print(find_rabbit("../data/alice.txt"))
    print(power(4, 7))


if __name__ == "__main__":
    main()
