'''
Created on 10 Dec 2020

@author: estudiante
Design a method called secondOrder that receives three integer positive number as parameters. 
This parameters are the coefficients of the an equation of a second order (ax2+bx+c=0) and the
 method returns the numbers of the solutions. If the parameters are not valid the method should return -1
'''
import math
def secondOrder(a=1,b=10,c=9):
    x=(b**2)-(4*a*c)
    if x==0:
        x1=(-b)/(2*a)
        return "Una solucion"+str(x1)
    else:
        x1=(-b+math.sqrt(x)/(2*a))
        x2=(-b-math.sqrt(x)/(2*a))
        return "Dos soluciones"+str(x1)+" y "+str(x2)
    
print(secondOrder())