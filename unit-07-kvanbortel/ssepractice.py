"""
Author: Kayla Van Bortel
"""


def count_letter(a_str):
    a_str = a_str.lower()
    freq = dict()
    letters = set()
    for letter in a_str:
        letters.add(letter)
    for each in letters:
        freq[each] = 0
    for letter in a_str:
        freq[letter] += 1
    return freq


# Write a function that accepts two dictionaries as parameters,
# and returns one dictionary that contains all elements from the
# two given.
# What is this new dictionary called?
def union(a_dict, b_dict):
    for key in a_dict:
        if key in b_dict:
            value = b_dict[key]
            b_dict[key] = value + a_dict[key]
        else:
            b_dict[key] = a_dict[key]
    return b_dict


# Write a function that accepts one string and returns
# the number of unique letters in that string.
def unique(a_string):
    unique = set()
    for each in a_string:
        unique.add(each)
    return len(unique)


# Write a function that accepts two sets as parameters
# and returns the intersection of the two sets.
def intersection(a_set, b_set):
    c_set = set()
    for each in a_set:
        if each in b_set:
            c_set.add(each)
    return c_set


def main():
    print(count_letter("aAbbc"))

    a_dict = {'a': 1, 'b': 1, 'd': 2}
    b_dict = {'a': 1, 'b': 2, 'e': 6}
    print(union(a_dict, b_dict))

    print(unique("aabbbc"))

    print(intersection({1, 2, 3, 5}, {1, 2, 4}))


if __name__ == "__main__":
    main()
