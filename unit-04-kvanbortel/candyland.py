"""
This program runs candyland with up to 4 players
Author: Kayla Van Bortel
"""

import random


def create_deck():
    """
    Creates a shuffled deck of all necessary cards
    """
    cards = (["SR", "SP", "SY", "SB", "SO", "SG"] * 4 +
             ["DR", "DP", "DY", "DB", "DO", "DG"] * 3 +
             ["_PM", "_PN", "LP", "IC"])
    shuffled_cards = []
    while cards:
        random_card = random.randrange(0, len(cards))
        shuffled_cards.append(cards[random_card])
        cards = cards[:random_card] + cards[random_card + 1:]
    return shuffled_cards


def create_board():
    """
    Creates the board with a specific layout
    """
    board = ["R", "P", "Y", "B", "O", "G"] * 13
    board[3] = "BS35"  # Skip to 36th spot
    board[17] = "GS24"  # Skip to 25th spot
    board.insert(20, "_PM")  # Peppermint
    board[26] = "PL"  # Licorice
    board.insert(32, "_PN")  # Peanut
    board.insert(49, "LP")  # Lollipop
    board[53] = "YL"  # Licorice
    board.insert(66, "IC")  # Ice Cream
    board.insert(82, "MC")  # Multicolored
    return board


def take_turn(player, board, deck):
    # player(color, location)
    # only skip fowards, never backwards
    location = player[1]
    if location > 0:
        location += 1
    card = deck.pop(-1)  # pulls the 'first' (last, so optimized) card from the deck
    print("Player ", player[0], " drew a ", card, ".", sep="")
    move_number = 0
    double_tracker = 0
    #  special cards
    if card == "_PM":
        return 20
    if card == "_PN":
        return 32
    if card == "LP":
        return 49
    if card == "IC":
        return 66
    #  other cards
    for position in board[location:]:
        #  single cards
        if card[1] == position[0] and card[0] == "S":
            #  handles skipping location
            if position == "BS35" and location < 35:
                print("Player ", player[0], " took a shortcut!", sep="")
                return 35
            if position == "GS24" and location < 24:
                print("Player ", player[0], " took a shortcut!", sep="")
                return 24
            return location + move_number
        #  double cards
        if card[1] == position[0] and card[0] == "D":
            if double_tracker == 2:  # it will find the second matching color
                #  handles skipping location
                if position == "GS24" and location < 24:
                    print("Player ", player[0], " took a shortcut!", sep="")
                    return 24
                return location + move_number
            double_tracker += 1
            move_number += 1

        else:
            if position == "MC":
                return 82
            move_number += 1


def play_game(num_players):
    deck = create_deck()
    board = create_board()
    player1 = ("Red", 0)
    player2 = ("Green", 0)
    player3 = ("Blue", 0)
    player4 = ("Purple", 0)
    lost_turn1 = 0
    lost_turn2 = 0
    lost_turn3 = 0
    lost_turn4 = 0
    while True:
        if num_players >= 1 and lost_turn1 == 0:
            location = take_turn(player1, board, deck)
            print("Player ", player1[0], " landed on ", board[location], location, ".", sep="")
            player1 = ("Red", location)
            #  handles a player losing a turn
            if location == 26 or location == 53:
                print("Player ", player1[0], " lost a turn.", sep="")
                lost_turn1 += 2
            #  handles a player winning
            if location == 82:
                print("Player ", player1[0], " wins!", sep="")
                return
        if num_players >= 2 and lost_turn2 == 0:
            location = take_turn(player2, board, deck)
            print("Player ", player2[0], " landed on ", board[location], location, ".", sep="")
            player2 = ("Green", location)
            if location == 26 or location == 53:
                print("Player ", player2[0], " lost a turn.", sep="")
                lost_turn2 += 2
            if location == 82:
                print("Player ", player2[0], " wins!", sep="")
                return
        if num_players >= 3 and lost_turn3 == 0:
            location = take_turn(player3, board, deck)
            print("Player ", player3[0], " landed on ", board[location], location, ".", sep="")
            player3 = ("Blue", location)
            if location == 26 or location == 53:
                print("Player ", player3[0], " lost a turn.", sep="")
                lost_turn3 += 2
            if location == 82:
                print("Player ", player3[0], " wins!", sep="")
                return
        if num_players == 4 and lost_turn4 == 0:
            location = take_turn(player4, board, deck)
            print("Player ", player4[0], " landed on ", board[location], location, ".", sep="")
            player4 = ("Purple", location)
            if location == 26 or location == 53:
                print("Player ", player4[0], " lost a turn.", sep="")
                lost_turn4 += 2
            if location == 82:
                print("Player ", player4[0], " wins!", sep="")
                return
        #  tracks lost turns
        if lost_turn1 > 0:
            lost_turn1 -= 1
        if lost_turn2 > 0:
            lost_turn2 -= 1
        if lost_turn3 > 0:
            lost_turn3 -= 1
        if lost_turn4 > 0:
            lost_turn4 -= 1


def main():
    num_players = input("How many players (1-4)? ")
    play_game(int(num_players))


if __name__ == "__main__":
    main()
