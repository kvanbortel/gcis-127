"""
Author: Kayla Van Bortel
"""

import csv
import plotter
import re


# Regular Expressions Practice:
# 1, 2, 3
# 12, 23
# 7, 7, 7, 7, 7, 7
# 778, 778
# a, b, c, _, 1, 2, 3
# _1

# Classes & Repetition Practice:
# '[R-T][a-zA-Z]*'
# '\d{3}-?\d{4}'
# '\d{5}'
# '\w+@rit.edu'
# '[a-z]{2, 3}\d{4}@rit.edu'


def first_only(filename):
    """
    Prints the first field in every record of a file
    """
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        # skip the header row
        next(csv_reader)
        # iterate over the records
        for record in csv_reader:
            print(record[0])


def names_and_addresses(filename):
    """
    Prints the names and addresses in the csv file
    """
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        # skip the header row
        next(csv_reader)
        # iterate over the records
        for record in csv_reader:
            print("Name:", record[0])
            print("Address:", record[1], end="\n\n")


def average(filename, column_num):
    """
    Print the average of a column
    """
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        # skip the header row
        next(csv_reader)
        total = 0
        count = 0
        # iterate over the records
        for record in csv_reader:
            total = total + float(record[column_num])
            count = count + 1
        return (total / count)


def plot_grades(filename, column_num):
    plotter.init("Student Grades", "Grade Item", "Grade")
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        # skip the header row
        header = next(csv_reader)
        plotter.new_series(header[column_num])
        # iterate over the records
        for record in csv_reader:
            plotter.add_data_point(float(record[column_num]))
    plotter.plot()


def numbers():
    """
    Prints the sum of the numbers in a file
    """
    filename = input("Enter filename: ")
    total = 0
    while (filename != ''):
        try:
            with open(filename) as file:
                sum = 0
                for line in file:
                    line = line.strip()
                    try:
                        number = float(line)
                        sum = sum + number
                    except ValueError:
                        print("Skipping non-numeric data:", line)
                total = total + sum
                print(sum)
        except FileNotFoundError:
            print("Cannot find file:", filename)
        filename = input("Enter filename: ")
    print("Total =", total)


def zip_check(filename):
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        # skip the header row
        next(csv_reader)
        # iterate over the records
        for record in csv_reader:
            address = record[1]
            if re.findall("[7-9]\\d{4}", address):
                print(record[0])


def main():
    # first_only("data/full_grades_010.csv")
    # names_and_addresses("data/full_grades_010.csv")
    # print(average("data/full_grades_010.csv", 3))
    plot_grades("data/full_grades_010.csv", 3)
    # numbers()
    # zip_check("data/full_grades_010.csv")


if __name__ == "__main__":
    main()
