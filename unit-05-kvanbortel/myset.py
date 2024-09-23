"""
Author: Kayla Van Bortel
"""


def make_myset(length, hash_func=hash):
    return (hash_func, [[] for _ in range(length)])


def add(myset, element):
    hash_func, table = myset
    index = hash_func(element) % len(table)
    if element not in table[index]:
        table[index].append(element)


def contains(myset, element):
    hash_func, table = myset
    index = hash_func(element) % len(table)
    return element in table[index]


def string_hash(a_string):
    max = 0
    for char in str(a_string):
        if ord(char) > max:
            max = ord(char)
    return max


def main():
    # myset = make_myset(7)
    myset = make_myset(7, string_hash)
    add(myset, 3)
    add(myset, 10)
    add(myset, 3)
    add(myset, 8)
    print(myset[1])
    print(contains(myset, 8))
    print(contains(myset, 4))
    print(string_hash("Hello world!"))
    print(string_hash("This is a string"))
    print(string_hash("This is a string!"))


if __name__ == "__main__":
    main()
