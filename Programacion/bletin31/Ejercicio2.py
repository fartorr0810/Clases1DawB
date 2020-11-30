'''
Created on 30 nov. 2020

@author: fran
2.Design a method called leapYear that returns 1 if the number that receives the method 
is a leap year. In other case, the method returns -1. A year is a leap year if 
it is multiple of 4 but the year is not multiple of 100 and not multiple of 400.
'''
ano = 1980
def leapYear(ano):
    if ano%4==0 and (ano%100!=0 or ano%400==0):
        return 1
    else:
        return -1

print(leapYear(ano))