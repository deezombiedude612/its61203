def euclidean(num1, num2):
    a = num1
    b = num2

    '''
    quotient = a // b
    remainder = a % b
    print(a, " = ", quotient, "(", b, ") + ", remainder)
    '''

    print("{} = {}({}) + {}".format(a, a // b, b, a % b))
    while not a % b == 0:
        temp = a % b
        a = b
        b = temp
        print("{} = {}({}) + {}".format(a, a // b, b, a % b))

    print("gcd({}, {}) = {}".format(num1, num2, b))
    print("lcm({}, {}) = {}".format(num1, num2, ((num1 * num2) // b)))


print("\n*** PYTHON EUCLIDEAN ALGORITHM ***\n")

num1 = input("Enter number 1 >> ")
while not num1.isnumeric():
    print("Invalid input. Try again.\n")
    num1 = input("Enter number 1 >> ")
num1 = int(num1)

num2 = input("Enter number 2 >> ")
while not num2.isnumeric():
    print("Invalid input. Try again.\n")
    num2 = input("Enter number 2 >> ")
num2 = int(num2)

print("\nPROCESS:")
if num1 >= num2:
    euclidean(num1, num2)
else:
    euclidean(num2, num1)
