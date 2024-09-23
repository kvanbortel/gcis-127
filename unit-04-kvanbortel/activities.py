"""
Author: Kayla Van Bortel
"""

import random


def tuples(a_tuple):
    print(len(a_tuple))
    print(a_tuple)
    for each in a_tuple:
        print(each)
    # a_tuple[1] = "a"


def scale(a_list, scalar):
    for index in range(len(a_list)):
        a_list[index] = a_list[index] * scalar
    return a_list


def cat(a_list, b_list):
    return a_list + b_list


def extender(a_list, b_list):
    a_list += b_list
    return a_list


def inserter(a_list, value):
    middle = len(a_list) // 2
    a_list.insert(middle, value)
    return a_list


def popper(a_list):
    if len(a_list) == 0:
        return

    index = random.randrange(len(a_list))
    value = a_list.pop(index)
    print(value, a_list)
    popper(a_list)


def tuple_equality(a_tuple, b_tuple):
    print(a_tuple, b_tuple)
    print(a_tuple is b_tuple)
    print(a_tuple == b_tuple)


def swapper(a_list):
    mid_index = len(a_list) // 2
    first_half = a_list[:mid_index]
    second_half = a_list[mid_index:]
    return second_half + first_half


def comprehension():
    """
    All of the letters in the string "foobar"
    15 0s
    The integers 0-12
    The even integers between 0 and 20
    The integers less than 50 divisible by 3 or 5
    """
    print([char for char in "foobar"])  # list("foobar")
    print(['0' for _ in range(15)])  # [0] * 15
    print([num for num in range(13)])  # list(range(13))
    print([num for num in range(21) if num % 2 == 0])  # list(range(0, 21, 2))
    print([num for num in range(50) if (num % 3 == 0) or (num % 5 == 0)])  # N/A


def make_table(rows, columns, value):
    # table = [[value for _ in range(columns)] for _ in range(rows)]
    # table = [[value] * columns] * rows
    # row, column
    table = []
    for _ in range(rows):
        row = []
        for _ in range(columns):
            row.append(value)
        table.append(row)

    for row in range(rows):
        print(table[row])
    return table


def sevens_key(num):
    if str(num)[0] == "7":
        return -1
    else:
        return num


def lucky_7s(a_list):
    print(a_list)
    a_list.sort(key=sevens_key)
    print(a_list)


def add(x, y):
    return x + y


def subtract(x, y):
    return x - y


def binary_operator(operation, x, y):
    return operation(x, y)


def main():
    # a_tuple = ("a", 123, False, range(10), 3.5)
    # tuples(a_tuple)
    # a_list = [0, 1, 2, 3]

    # print(a_list)
    # scale(a_list, 2)
    # print(a_list)

    # a_list = [1, 2, 3]
    # b_list = [4, 5, 6]
    # c_list = cat(a_list, b_list)
    # print(a_list, b_list, c_list)

    # a_list = [1, 2, 3]
    # b_list = [4, 5, 6]
    # c_list = extender(a_list, b_list)
    # print(a_list, b_list, c_list)

    # a_list = []
    # for count in range(10):
    #     inserter(a_list, count)
    #     print(a_list)

    # print(a_list)
    # popper(a_list)
    # print(a_list)

    # a_list = [1, 2, 3]
    # a = tuple(a_list)
    # b = tuple(a_list)
    # c = (5, 6, 7)
    # tuple_equality(a, a)
    # tuple_equality(a, b)
    # tuple_equality(a, c)

    # print(swapper([]))
    # print(swapper([1]))
    # print(swapper([1, 2, 3]))
    # print(swapper([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))

    # comprehension()

    # print(make_table(4, 5, 'A'))

    lucky_7s(list(range(0, 100, 7)))

    print(binary_operator(add, 5, 6))
    print(binary_operator(subtract, 8, 3))


if __name__ == "__main__":
    main()
