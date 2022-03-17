


def getNumber(ommit = ()):
    list = []
    for i in range(1,26):
        list.append(i)
        for j in ommit:
            if j == i:
                list.remove(j)
    return list

class Student():
    def __init__(self, age,name,grade):
        self.age = age
        self.name = name
        self.grade = grade

allStudents = {"1":Student(15,"astrid", -3), "2": Student(18,"martin",12)  }

print(allStudents["1"].name)

