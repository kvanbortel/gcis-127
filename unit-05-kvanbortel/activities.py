"""
Author: Kayla Van Bortel
"""

# import timing
import random
import re


def square(x):
    return x ** 2


def double(x):
    return x * 2


def negate(x):
    return -x


def apply_transformation(a_list, transformer):
    transformed = []
    for value in a_list:
        transformed.append(transformer(value))
    return transformed


def unique_list(a_list, value):
    # for item in a_list:  # Linear search
    #     if item == value:
    #         return
    # a_list.append(value)
    if value not in a_list:  # O(n)
        a_list.append(value)


def fill_list(length):
    a_list = []
    for i in range(length):
        unique_list(a_list, i)


def sets():
    a_set = {1, 3, 4}
    print(a_set)
    a_set.add(5)
    a_set.add(2)
    print(a_set)
    a_set = set("aabbccd")
    print(a_set)
    a_set = {1, "A", False, 3.5}
    print(a_set)


def unique_set(a_set, value):
    if value not in a_set:  # O(1)
        a_set.add(value)


def fill_set(length):
    a_set = set()
    for i in range(length):
        unique_set(a_set, i)


def coupon_collector(n):
    a_set = set()
    count = 0
    while len(a_set) < n:
        num = random.randint(1, n)
        a_set.add(num)
        count += 1
    return count


def mixup():
    a_set = set("randomly")
    for char in a_set:
        print(char, end=" ")
    print()


def unique_words(filename):
    unique_words = set()
    with open(filename) as file:
        for line in file:
            line = line.strip().lower()
            if line != "":
                words = line.split()
                for each in words:
                    # for match in re.findall("[a-z]+[']?[a-z]{1,2}", each):
                    for match in re.findall("[a-z-']+", each):
                        unique_words.add(match)
    return unique_words


def superset(a_set, b_set):
    for item in b_set:
        if item not in a_set:
            return False
    return True


def subset(a_set, b_set):
    for item in a_set:
        if item not in b_set:
            return False
    return True


def intersection(a, b):
    c = set()
    for value in a:
        if value in b:
            c.add(value)
    return c


def union(a, b):
    c = set()
    for value in b:
        c.add(value)
    for value in a:
        c.add(value)
    return c


def minus(a, b):
    c = set()
    for value in a:
        if value not in b:
            c.add(value)
    return c


def names():
    names = {}
    names["K"] = "Kayla"
    names["J"] = "Jean"
    names["V"] = "Van Bortel"
    names["J"] = "Jared"
    names["E"] = "Eugene"
    names["V"] = "Van Bortel"
    names["S"] = "Sandra"
    names["J"] = "Jean"
    names["V"] = "Van Bortel"
    print(names)
    print(names["K"], names["J"], names["V"])
    print(names["J"], names["E"], names["V"])
    print(names["S"], names["J"], names["V"])


def print_dict(a_dict):
    for key in a_dict:
        value = a_dict[key]
        print(key, ":", value)


def find_maximum(dictionary):
    max_key = ""
    max_value = -999
    for key in dictionary:
        value = dictionary[key]
        if value > max_value:
            max_key = key
            max_value = value
    return max_key, ":", max_value


def count_words(filename):
    freq = {}
    with open(filename) as file:
        for line in file:
            line = line.strip().lower()
            if line != "":
                words = line.split()
                for word in words:
                    finds = re.findall("[a-z-']+", word)
                    if len(finds) > 0:
                        word = finds[0]
                        if word in freq:
                            freq[word] += 1
                        else:
                            freq[word] = 1
    return freq


def hashes():
    print(hash("Hello World!"))
    print(hash("Hello World!"))

    print(hash("Hello world!"))
    print(hash("Hello world!"))

    print(hash("A" * 100000))
    print(hash("A" * 10000000000))


def main():
    # a_list = list(range(1, 11))
    # print("Square:", apply_transformation(a_list, square))
    # print("Double:", apply_transformation(a_list, double))
    # print("Negate:", apply_transformation(a_list, negate))
    # print(timing.time_function(fill_list, 5000))
    # print(timing.time_function(fill_list, 10000))
    # print(timing.time_function(fill_list, 15000))
    # # sets()
    # print(timing.time_function(fill_set, 5000))
    # print(timing.time_function(fill_set, 10000))
    # print(timing.time_function(fill_set, 15000))
    # print(coupon_collector(10000))
    # mixup()
    # mixup()
    # mixup()
    # print((unique_words("data/alice.txt")))
    # print(len((unique_words("data/alice.txt"))))
    # print(superset({1, 2}, {1, 2, 4}))
    # print(superset({1, 2, 4}, {1, 2}))
    # print(subset({1, 2}, {1, 2, 4}))
    # print(subset({1, 2, 4}, {1, 2}))
    # print(minus({1, 2, 3}, {1, 3}))
    # print(intersection({1, 2, 3}, {1, 2, 4}))
    # print(union({1, 2, 3}, {1, 2, 4}))
    # names()
    # a_dict = {"one": 1, "two": 2}
    # print_dict(a_dict)
    # dictionary = {"a": 1, "b": 7, "c": 2}
    # print(find_maximum(dictionary))

    # words = count_words("data/alice.txt")
    # word_list = [[words[key], key] for key in words]
    # sorted_words = sorted(word_list, reverse=True)
    # for word in sorted_words[:20]:
    #     print(word[1], ":", word[0])

    hashes()


if __name__ == "__main__":
    main()
