"""
Author: Kayla Van Bortel
"""

import csv
import re
import random


def is_palindrome(word):
    l_word = word.lower()
    reverse = ""
    for i in range(len(l_word) - 1, -1, -1):
        reverse += l_word[i]
    print(reverse)


def harmonic_sum(num):
    sum = 0
    for i in range(1, num + 1):
        sum += float(1/i)
    print(sum)


def open_file(filename):
    try:
        file = open(filename)
        print("Opened")
        file.close()
        print("Closed")
    except FileNotFoundError:
        print(filename, "not found.")


def odd_lines(filename):
    with open(filename) as file:
        i = 0
        count = 1
        for line in file:
            if (i + 1) % 2 != 0:
                print(line)
            i += 1
            count += 1
        return count


def even_letters(filename):
    with open(filename) as file:
        even_string = ""
        for line in file:
            line = line.strip()
            i = 0
            for match in re.findall("[A-Za-z]", str(line)):
                if i % 2 == 0:
                    even_string += match
                i += 1
        print(even_string)


def average_words(filename):
    with open(filename) as file:
        word_count = 0
        line_count = 0
        for line in file:
            line = line.strip()
            if line != "":
                words = line.split()
                line_count += 1
                for each in words:
                    word_count += 1
    if line_count == 0:
        raise ValueError
    return word_count / line_count


def field_count(filename):
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        r_count = 0
        f_count = 0
        for record in csv_reader:
            r_count += 1
            for field in record:
                f_count += 1
    print(f_count)


def recursive(num):
    if num < 1:
        return None
    if num == 1:
        return 1
    if num % 2 != 0:
        return num + recursive(num + 1)
    if num % 2 == 0:
        return num + recursive(num / 2)
# F(1) = 1
# F(N) = N + F(N+1) if N is odd
# F(N) = N + F(N/2) if N is even
# F(N) where N < 1 is undefined


def linear_search_rec(an_array, target, index=0):
    if index == len(an_array):
        return None
    if an_array[index] == target:
        return index
    else:
        return linear_search_rec(an_array, target, index + 1)


def shuffle(an_array):
    shuffled = False
    i = 0
    while shuffled is False:
        rnd_index = random.randint(0, len(an_array) - 1 - i)
        temp = an_array[len(an_array) - 1 - i]
        an_array[len(an_array) - 1 - i] = an_array[rnd_index]
        an_array[rnd_index] = temp
        i += 1
        if i >= len(an_array):
            shuffled = True
    return an_array


def random_search(an_array, target):
    random_indexes = shuffle(list(range(0, len(an_array))))
    for i in range(len(an_array)):
        index = random_indexes[i]
        if an_array[index] == target:
            return index
    return None


def main():
    # is_palindrome("rAcecar")
    # is_palindrome("hello")
    # harmonic_sum(3)
    # a = 3
    # print("This is", "a test.", a)
    # print("This is" + "a test.", a)
    # open_file("data/alice.txt")
    # print(odd_lines("data/alice.txt"))
    # even_letters("data/alice.txt")
    # print(average_words("data/alice.txt"))
    # field_count("data/grades_010.csv")
    # open_file("no.txt")
    # try:
    #     print(average_words("empty.txt"))
    # except ValueError:
    #     print("Empty txt")
    # print(recursive(0))
    # print(recursive(1))
    # print(recursive(10))
    # print(recursive(15))
    # print(recursive(100))
    # print(recursive(101))
    # print(linear_search_rec([1, 2, 3, 4, 5], 5))
    # random.seed(1)
    # print(shuffle([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
    print(random_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 10))


if __name__ == "__main__":
    main()
