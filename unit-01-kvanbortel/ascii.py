"""
Converts a character to ASCII and a number from ASCII.
Also gives the alphabet position of uppercase letters.
Author: Kayla Van Bortel
"""

ASCII_A = ord("A")


def convert_to_ascii(character):
    """
    Converts a character to ASCII
    """
    print(ord(character))


def convert_from_ascii(number):
    """
    Converts a number from ASCII
    """
    print(chr(number))


def alphabet_position(letter, ASCII_A):
    """
    Gives the position in the alphabet of an uppercase letter
    """
    letter_position = ord(letter) - ASCII_A + 1
    print(letter, "is in the position", letter_position, "in the alphabet")


def main():
    convert_to_ascii("K")
    convert_from_ascii(42)
    alphabet_position("A", ASCII_A)
    alphabet_position("A", 5)
    alphabet_position("A", 7)


main()
