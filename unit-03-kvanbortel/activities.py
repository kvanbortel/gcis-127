"""
Author: Kayla Van Bortel
"""

import random


def literal_list():
    literal_list = ["a", 1, 3.0, False, "ba"]
    return literal_list


def sequence_list(sequence):
    return list(sequence)


def print_list(a_list):
    for element in a_list:
        print(element, end=" ")
    print()


def append_to_list(sequence):
    a_list = []
    for item in sequence:
        print(a_list)
        a_list.append(item)
    return a_list


def roll_the_die(sides):
    return random.randint(1, sides)


def countdown(n):
    """
    Practice with recursion
    """
    if n == 0:
        print(0)
        return 0

    print(n)
    return n + countdown(n - 1)


def factorial(n):
    if n < 0:
        return None
    elif n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)


def main():
    # print_list(literal_list())
    # print_list(sequence_list(range(2, 100, 17)))
    # print(append_to_list(range(10, 20)))
    # random.seed(1)
    # for _ in range(10):
    #     print(roll_the_die(6))
    print("Sum = ", (countdown(15)))
    print(factorial(10))
    print(factorial(100))
    print(factorial(998))  # called Python, then called main()
    # print(factorial(1000))
    # print(factorial(2000))


if __name__ == "__main__":
    main()
