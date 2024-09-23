"""
Generates a random password given the totals of each ASCII type
Author: Kayla Van Bortel
"""

import random


def create_ascii_range_string(start, stop):
    """
    Returns consecutive characters
    """
    a_string = ""
    for each in range(start, stop):
        a_string = a_string + chr(each)
    return a_string


def create_uppercase_letters_string():
    return create_ascii_range_string(65, 91)


def create_lowercase_letters_string():
    return create_ascii_range_string(97, 123)


def create_digits_string():
    return create_ascii_range_string(48, 58)


def create_symbols_string():
    symbols_string = create_ascii_range_string(33, 48)
    symbols_string = symbols_string + create_ascii_range_string(58, 65)
    symbols_string = symbols_string + create_ascii_range_string(91, 97)
    symbols_string = symbols_string + create_ascii_range_string(123, 127)
    return symbols_string


def get_random_char_from_string(a_string):
    index = random.randrange(0, len(a_string))
    return a_string[index]


def generate_random_password(total_uppercase, total_lowercase, total_digits, total_symbols):
    """
    Generates a random password given total counts of each ASCII type
    """
    count_uppercase = 0
    count_lowercase = 0
    count_digits = 0
    count_symbols = 0
    password_length = total_uppercase + total_lowercase + total_digits + total_symbols
    password = ""

    while (len(password) < password_length):
        rand_val = random.randint(0, 3)
        if rand_val == 0 and count_uppercase < total_uppercase:
            password = password + get_random_char_from_string(create_uppercase_letters_string())
            count_uppercase = count_uppercase + 1
        elif rand_val == 1 and count_lowercase < total_lowercase:
            password = password + get_random_char_from_string(create_lowercase_letters_string())
            count_lowercase = count_lowercase + 1
        elif rand_val == 2 and count_digits < total_digits:
            password = password + get_random_char_from_string(create_digits_string())
            count_digits = count_digits + 1
        elif rand_val == 3 and count_symbols < total_symbols:
            password = password + get_random_char_from_string(create_symbols_string())
            count_symbols = count_symbols + 1
    return password


def main():
    totals = input("Enter <num uppers> <num lowers> <num digits> <num symbols>: ")
    if totals == "":
        print("Goodbye!")
        quit()
    else:
        tokens = totals.split()
        while len(tokens) != 4:
            print("Error: You must enter exactly 4 values")
            totals = input("Enter <num uppers> <num lowers> <num digits> <num symbols>: ")
            tokens = totals.split()
        print(generate_random_password(int(tokens[0]), int(tokens[1]), int(tokens[2]), int(tokens[3])))


if __name__ == "__main__":
    main()
