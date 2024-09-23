"""
This program contains functions for plotting grades in csv files
Author: Kayla Van Bortel
"""

import plotter
import csv
import re


def plot_grades(filename, first_name, last_name):
    """
    Plots all of the grades for a student
    """
    plotter.init(first_name + " " + last_name, "Grade Item", "Score")
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)  # skip the header row
        plotter.new_series(first_name + " " + last_name)
        # find student
        student = None
        while student is None:
            record = next(csv_reader)
            name = record[0]
            if re.findall(last_name + ", .*" + first_name, name):
                student = record
        # plot grades for student
        for entry in range(3, len(student)):
            plotter.add_data_point(float(student[entry]))
    plotter.plot()


def get_average(filename, column):
    """
    Returns the class average for the specified column
    """
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        total = 0
        count = 0
        for record in csv_reader:
            try:
                total = total + float(record[column])
                count = count + 1
            except ValueError:
                print("\'" + record[column] + "\'", "cannot be converted to a number")
    return total / count


def plot_class_averages(filename):
    """
    Plots the class average for each assignment
    """
    plotter.init("Class Averages (" + filename + ")", "Grade Items", "Average")
    plotter.new_series("Class Averages")
    for entry in range(3, 30):
        plotter.add_data_point(get_average(filename, entry))
    plotter.plot()


def main():
    # plot_grades("data/full_grades_010.csv", "Sion", "Lobasso")
    # print(get_average("data/full_grades_010.csv", 5))
    # plot_class_averages("data/full_grades_010.csv")
    plot_grades("data/full_grades_100.csv", "Leon", "Zagar")
    plot_grades("data/full_grades_100.csv", "Janeka", "Benyard")
    plot_class_averages("data/full_grades_999.csv")


if __name__ == "__main__":
    main()
