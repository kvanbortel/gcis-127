"""
This program prompts for 10 words or phrases and uses them to create a Mad Libs story
Author: Kayla Van Bortel
"""


def main():
    adjective1 = input("Adjective: ")
    plural_noun1 = input("Plural noun: ")
    adjective2 = input("Adjective: ")
    plural_furnishing = input("Plural furnishing: ")
    adjective3 = input("Adjective: ")
    plural_noun2 = input("Plural noun: ")
    ing_verb = input("Verb ending in -ing: ")
    verb_past_tense = input("Past tense verb: ")
    noun2 = input("Noun: ")
    verb_past_tense2 = input("Past tense verb: ")

    print("It was a ", adjective1, " day in the RIT tunnels.", sep="", end=" ")
    print(
        "The ", plural_noun1, " were ", adjective2, " and the ", plural_furnishing, " were ", adjective3, ".",
        sep="", end=" ",
    )
    print("But then there was a strange sound.", end=" ")
    print("It sounded like ", plural_noun2, " ", ing_verb, ".", sep="", end="\n\n")
    print("I quickly ", verb_past_tense, " to the ", noun2, " mural.", sep="", end=" ")
    print("Then I pressed a special RIT brick and escaped.", end=" ")
    print("When I was finally outside, I ", verb_past_tense2, ".", sep="")


main()
