"""
Author: Kayla Van Bortel
"""

import random


# Swap sort
def swap_sort(a_list):
    for i in range(len(a_list)):
        for j in range(i):
            if a_list[i] < a_list[j]:
                temp = a_list[j]
                a_list[j] = a_list[i]
                a_list[i] = temp
    return a_list


# Passing in functions
def what_does_the_fox_say(a_function):
    print("The fox says... " + a_function())


def bark():
    return "Bark!"


def screech():
    return "Screech."


# Make tuple
def make_tuple(a, b, c):
    return (a, b, c)


# Reverses tuple with any values
def reverse_tuple(a_tuple):
    return a_tuple[::-1]


# Make card and sort by custom key
def make_trading_card(name, mana_value, power, toughness):
    return (name, mana_value, power, toughness)


def trading_card_value(card):
    return card[2] + card[3]


def trading_card_sort_key(card):
    return trading_card_value(card)


# nth list
def nth_list(sequence, n):
    a_list = []
    count = 1
    for each in sequence:
        if count % n == 0:
            a_list.append(each)
        count += 1
    return a_list


# odds before evens
def odds_before_evens(a_list):
    for i in range(1, len(a_list)):
        if a_list[i] % 2 != 0 and i != 0:
            j = i
            while j > 0 and a_list[j - 1] % 2 == 0:
                temp = a_list[j - 1]
                a_list[j - 1] = a_list[j]
                a_list[j] = temp
                j -= 1
    return a_list


def odds_before_evens_sort_key(each):
    if each % 2 == 0:
        return 1
    else:
        return -1


# splice
def splice(a_list, b_list):
    a_list += b_list


# Using slicing, your function should append all characters in the string into
# a list, then using slicing, print the word out backwards. Be sure your function
# is able to handle if the word starts or ends with a space.
def scramble(s):
    a_list = []
    a_list[:0] += s
    print(a_list[::-1])


# Using list comprehension, your function should create a list from all integer
# values 1-100 that are divisible by 3, 5, or both.
def fizz_buzz_list():
    a_list = [i for i in range(1, 101) if i % 3 == 0 or i % 5 == 0]
    return a_list


# Use list comprehension to create a list that has all of the values from the sequence
# that are evenly divisible by n. For example, if called with
# sequence=range(10) and n=4 it should return [0, 4, 8].
def multiples(sequence, n):
    return [i for i in sequence if i % n == 0]


# Search for the target by checking the values at random indices until you find the target
# (return the index) or run out of indexes to check (return None). You should not check the
# same index twice (hint: might be helpful to use the random module to create a list of random
# values). Test your function from main by creating a random list with 20 values and searching
# for all values from 0 to 20. What is the time complexity of this function?
# >>> O(1) best, O(log(n)) average, O(n) worst
def random_search(a_list, target):
    rnd_indexes = set()
    while len(rnd_indexes) < len(a_list):
        rnd = random.randrange(len(a_list))
        rnd_indexes.add(rnd)
    for each in rnd_indexes:
        if a_list[each] == target:
            return each
    return None


# Return True if the sequences contain all of the same values, even if they are in a different order,
# and False otherwise. For example, if you called the function with a=(2, 1, 3) and b=range(1, 4) the
# function would return True. because all of the elements in a are also in b and vice versa. A naive
# solution runs in O(n2) time. Can you implement a faster version? Can you implement an O(n) version?
def equivalent(a_sequence, b_sequence):
    return set(a_sequence) == set(b_sequence)


# dictionary stuff
def random_counts(n):
    freq = dict()
    while len(freq) < n:
        r = random.randrange(n)
        if r in freq:
            freq[r] += 1
        else:
            freq[r] = 1
    return freq


# Using another dictionary, determine the list of unique values that were generated
# for each count. For example, using the dictionary returned by your previous function
# after setting the random seed to 7, you should find that 997, 2961, 3648, 3926, 4277,
# and 6809 were all generated 18 times. You should also find that the most commonly occurring
# count is 6, with 1443 different values generated 6 times. Print each count and its frequency in sorted order
def frequencies(freq):
    counts = dict()
    for each in freq:
        if freq[each] in counts:
            counts[freq[each]] += 1
        else:
            counts[freq[each]] = 1
    keys = []
    for key in counts:
        keys.append(key)
    sorted_keys = sorted(keys)
    for key in sorted_keys:
        print(key, ":", counts[key])


# decoding
def cereal_box_decoder(s):
    chars = s.split(", ")
    decoded = ""
    for each in chars:
        decoded += chr(int(each))
    return decoded


# hash collisions
# iterate through both lists and identify any hash collisions between values within the lists.
# When completed, your function should return a list of all values that caused collisions. 
def find_hash_collisions(a_list, b_list):
    a_set = a_list
    b_set = b_list
    
    print(a_set)
    a_hash = []
    b_hash = []
    collisions = []
    for each in a_list:
        a_hash.append(hash(each))
    for each in b_list:
        b_hash.append(hash(each))
    for each_a in a_hash:
        for each_b in b_hash:
            if each_a == each_b:
                collisions.append(each_a)
    print(collisions)


def main():
    a_list = [5, 4, 3, 2, 1]
    print(swap_sort(a_list))

    what_does_the_fox_say(bark)

    print(make_tuple(1, 2, 3))
    print(make_tuple(3, 2, 1))

    print(reverse_tuple((1, "two", [3], (4, 5))))

    card1 = make_trading_card("Card1", "ARR", 20, 6)
    card2 = make_trading_card("Card2", "ARRGG", 10, 3)
    card3 = make_trading_card("Card3", "AGRR", 4, 2)
    card4 = make_trading_card("Card4", "ARASR", 35, 2)
    cards = [card1, card2, card3, card4]
    cards.sort(key=trading_card_sort_key)
    print(cards)

    print(nth_list(range(1, 11), 2))
    print(nth_list("String", 2))

    print(odds_before_evens([3, 4, 1, 2, 5]))

    nums = [3, 4, 1, 2, 5]
    nums.sort(key=odds_before_evens_sort_key)
    print(nums)

    a_list = [1, 2]
    b_list = ['a', 'b']
    print(a_list)
    splice(a_list, b_list)
    print(a_list)

    scramble(" abcdef ")

    print(fizz_buzz_list())

    print(multiples(range(10), 4))

    print(random_search([i for i in range(21)], 10))

    print(equivalent((2, 1, 3), range(1, 4)))


    freq = random_counts(10000)
    # Call your function from main with n=10000 and use the dictionary that is returned to determine the
    # total number of times random.randint was called, the maximum number of times that any value was
    # generated, and the sorted list of values that were generated the maximum number of times. If you set
    # the random seed to 7 before calling your function you should see that the total is 74617, the maximum
    # number of times a value was generated is 18, and the sorted list of values generated that many times
    # is [997, 2961, 3648, 3926, 4277, 6809].
    count = 0
    for key in freq:
        count += freq[key]
    print(count)

    max = 0
    for key in freq:
        if freq[key] > max:
            max = freq[key]
    print(max)

    sorted_vals = []
    for key in freq:
        if freq[key] == max:
            sorted_vals.append(key)
    print(sorted(sorted_vals))


    print(frequencies(freq))

    print(cereal_box_decoder("26, 28, 29, 27, 1, 2, 4, 6"))

    find_hash_collisions(["1", "2", "3"], ["1", "2", "4"])


if __name__ == "__main__":
    main()
