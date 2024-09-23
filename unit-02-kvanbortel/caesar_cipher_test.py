"""
Author: Kayla Van Bortel
"""

import caesar_cipher


def test_encrypt_letter_A_3():
    # setup
    letter = "A"
    shift = 3
    expected = "D"

    # invoke
    actual = caesar_cipher.encrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_encrypt_letter_G_5():
    # setup
    letter = "G"
    shift = 5
    expected = "L"

    # invoke
    actual = caesar_cipher.encrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_encrypt_letter_D_10():
    # setup
    letter = "D"
    shift = 10
    expected = "N"

    # invoke
    actual = caesar_cipher.encrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_encrypt_letter_f_3():
    # setup
    letter = "f"
    shift = 3
    expected = ""

    # invoke
    actual = caesar_cipher.encrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_is_alphabetic_A():
    character = "A"
    expected = True

    actual = caesar_cipher.is_alphabetic(character)

    assert actual == expected


def test_is_alphabetic_Z():
    character = "Z"
    expected = True

    actual = caesar_cipher.is_alphabetic(character)

    assert actual == expected


def test_is_alphabetic_z():
    character = "z"
    expected = False

    actual = caesar_cipher.is_alphabetic(character)

    assert actual == expected


def test_decrypt_letter_D_3():
    # setup
    letter = "D"
    shift = 3
    expected = "A"

    # invoke
    actual = caesar_cipher.decrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_decrypt_letter_f_8():
    # setup
    letter = "f"
    shift = 8
    expected = ""

    # invoke
    actual = caesar_cipher.decrypt_letter(letter, shift)

    # analysis
    assert actual == expected


def test_encrypt_message_ABCDE_3():
    # setup
    message = "ABCDE"
    shift = 3
    expected = "DEFGH"

    # invoke
    actual = caesar_cipher.encrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_encrypt_message_VWXYZ_3():
    # setup
    message = "VWXYZ"
    shift = 3
    expected = "YZABC"

    # invoke
    actual = caesar_cipher.encrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_encrypt_message_ABCDEFG_3():
    # setup
    message = "ABCDEFG"
    shift = 3
    expected = "DEFGHIJ"

    # invoke
    actual = caesar_cipher.encrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_decrypt_message_DEFGHIJ_3():
    # setup
    message = "DEFGHIJ"
    shift = 3
    expected = "ABCDEFG"

    # invoke
    actual = caesar_cipher.decrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_decrypt_message_ABC_3():
    # setup
    message = "ABC"
    shift = 3
    expected = "XYZ"

    # invoke
    actual = caesar_cipher.decrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_decrypt_message_GHI_2():
    # setup
    message = "GHI"
    shift = 2
    expected = "EFG"

    # invoke
    actual = caesar_cipher.decrypt_message(message, shift)

    # analysis
    assert actual == expected


def test_decrypt_message_GHI():
    # setup
    message = "GHI"
    expected = "DEF"

    # invoke
    actual = caesar_cipher.decrypt_message(message)

    # analysis
    assert actual == expected
