import csv
import plotter


def csv_test(filename):
    plotter.init("Title", "X", "Y")
    plotter.new_series("Series")
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        for record in csv_reader:
            try:
                plotter.add_data_point(float(record[7]))
            except ValueError:
                print("Fail")
    plotter.plot()


def plotter_test(n):
    plotter.init("Title", "X", "Y")
    plotter.new_series("Series")
    plotter.add_data_point(9)
    plotter.plot()


def file_test(filename):
    with open(filename) as file:
        for line in file:
            print(line)


def fib_test(n):
    if n <= 0:
        return None
    if n == 1:
        return 0
    if n == 2:
        return 1
    if n > 1:
        return fib_test(n - 1) + fib_test(n - 2)


def main():
    # csv_test("data/full_grades_010.csv")
    # plotter_test(9)
    # file_test("data/alice.txt")
    print(fib_test(9))


if __name__ == "__main__":
    main()
