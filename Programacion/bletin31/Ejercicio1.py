'''
Created on 29 nov. 2020

@author: fran
1.Design a method called factorial that receives a positive integer and returns the factorial. 
If the number is negative the method should return -1.
'''
def factorial(number):
    factorial=0
    if number<0:
        return -1
    else:
        for i in range(1,number+1):
            factorial+=number*i
    return factorial

print(factorial(-2))
print(factorial(5))