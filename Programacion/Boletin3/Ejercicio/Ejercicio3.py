'''
Created on 17 nov. 2020

@author: xXxArroyoxXx
'''
'''
3.Disenar un programa que lea numeros hasta que el usuario introduzca el 0.
Debe informar dela media de los numeros leidos (sin tener en cuenta el 0)
 y el valor maximo y minimo introducido
'''
def contadornums(numaintroducir):
    suma=0
    i=0
    mayor=0
    menor=0
    mensajemayor=""
    mensajemenor=""
    while i!=numaintroducir:
        num=int(input("Introduce un numero"))
        if num<=0:
            i=i-1
        else:
            suma+=num
            i=i+1
            if num>mayor:
                mayor=num
                mensajemayor="El numero mayor es "+str(mayor)
            if num<menor:
                menor=num
                mensajemenor="El mumero menor es "+str(menor)
    return suma/numaintroducir,mensajemayor,mensajemenor
    
print(contadornums(numaintroducir=int(input("Que numeros deseas introducir"))))