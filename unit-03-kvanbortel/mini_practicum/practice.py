"""
Author: Kayla Van Bortel
"""

PI_DIGITS = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679"


def absolute_difference(a, b):
    difference = a - b
    if difference < 0:
        return -difference
    return difference


def pi_tester():
    score = 0
    while score < 100:
        digit = input("Enter the next digit: ")
        for each in PI_DIGITS:
            if digit == each:
                score = score + 1
            else:
                return score
            digit = input("Enter the next digit: ")
    return score


def main():
    print("Score:", pi_tester())


if __name__ == "__main__":
    main()
