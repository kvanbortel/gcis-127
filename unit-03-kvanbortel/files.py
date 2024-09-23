"""
Author: Kayla Van Bortel
"""


def print_lines(filename):
    with open(filename) as file:
        for line in file:
            stripped = line.strip()
            print(stripped)


def word_search(filename):
    """
    Searches for a word in a file
    """
    with open(filename) as file:
        target = input("Enter a word: ")
        for line in file:
            word = line.strip().lower()
            if word == target.lower():
                print("Found the word:", word)
                return
        print(target, "was not found.")


def first_words(filename, max):
    word_list = []
    with open(filename) as file:
        for line in file:
            words = line.split()
            if len(word_list) < max:
                if len(words) > 0:
                    word_list.append(words[0])
            else:
                return word_list
        return word_list


def main():
    print_lines("data/alice.txt")
    word_search("data/words.txt")
    print(first_words("data/alice.txt", 30))


if __name__ == "__main__":
    main()
