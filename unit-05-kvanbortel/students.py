"""
This program uses encapsulation
Author: Kayla Van Bortel
"""


def make_student(id, name):
    return [id, name, 0, 0]


def add_student(population, id, name):
    population[id] = make_student(id, name)
    # for student in population:
    #     if student[0] == id:
    #         population.remove(student)
    # population.append(make_student(id, name))


def get_student(population, id):
    return population[id]
    # for student in population:
    #     # if student[0] == id:
    #         return student
    # return None


def add_credits(population, id, credits):
    student = get_student(population, id)
    if student is not None:
        student[2] += credits
    else:
        raise ValueError(id + " is not in the population")


def get_credits(population, id):
    student = get_student(population, id)
    if student is not None:
        return student[2]
    else:
        raise ValueError(id + " is not in the population")


def main():
    population = {}
    add_student(population, "XXX1337", "Kayla")
    add_student(population, "ABC1010", "Sandra")
    add_student(population, "DEF9999", "Emily")
    add_student(population, "XYZ1616", "OhNo")
    add_student(population, "XYZ1616", "Landon")
    for student in population:
        print(student)
    print(get_student(population, "XXX1337"))
    # print(get_student(population, "YYY1111"))
    add_credits(population, "XXX1337", 4)
    print(get_credits(population, "XXX1337"))


if __name__ == "__main__":
    main()
