"""
Encrypts a letter using the Caesar cipher
Author: Kayla Van Bortel
"""

'''Default Shift'''
DEFAULT_SHIFT = 3
'''Amount of letters in the alphabet'''
LETTERS_IN_ALPHABET = 26


def encrypt_letter(letter, shift):
    """
    Encrpyts uppercase letters using Caesar cipher
    """
    if is_alphabetic(letter):
        ord_letter = ord(letter)  # take the ascii value of the letter
        ord_shifted = int(ord_letter) + int(shift)  # add the shift to the ascii value of the letter
        if not is_alphabetic(chr(ord_shifted)):
            ord_shifted = ord_shifted - LETTERS_IN_ALPHABET
        return chr(ord_shifted)  # return the character for that ascii value
    else:
        return ''


def is_alphabetic(character):
    """
    Returns True if uppercase letter, False otherwise
    """
    return character >= 'A' and character <= 'Z'


def decrypt_letter(letter, shift):
    """
    Returns decrypted letter if uppercase letter, empty string otherwise
    """
    ord_letter = ord(letter)  # take the ascii value of the letter
    ord_decrypted = ord_letter - shift  # subtract the shift from the ascii value of the letter
    if ord_decrypted < ord("A"):
        ord_decrypted = ord_decrypted + LETTERS_IN_ALPHABET
    if is_alphabetic(chr(ord_decrypted)):  # make sure letter is an uppercase letter
        return chr(ord_decrypted)  # return the character for that ascii value
    else:  # otherwise return empty string
        return ''


def encrypt_message(message, shift=DEFAULT_SHIFT):
    """
    Encrypts a message of any length
    """

    ciphertext = ""
    for index in range(len(message)):
        ciphertext = ciphertext + encrypt_letter(message[index], shift)
    return ciphertext


def decrypt_message(message, shift=DEFAULT_SHIFT):
    """
    Decrypts a message of any length
    """
    ciphertext = ""
    for each_letter in message:
        ciphertext = ciphertext + decrypt_letter(each_letter, shift)
    return ciphertext


def main():
    # letter = input("Enter a letter to encrypt: ")
    # shift = input("Enter a shift: ")
    # encrypted_letter = encrypt_letter(letter, shift)
    # print(encrypted_letter)
    # message = input("Enter a message to encrypt: ")
    # shift = input("Enter a shift: ")
    # print(encrypt_message(message, shift))
    message = input("Enter a phrase containing at least one space: ")
    words = message.split()
    for word in words:
        print(encrypt_message(word))


if __name__ == "__main__":
    main()
