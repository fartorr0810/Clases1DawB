'''
Created on 29 nov. 2020

@author: fran
'''

cadena="He estudiado mucho"
def contartexto(cadena):
    numeropalabras=0
    for i in cadena:
        caracter=cadena.join(i)
        if str(caracter)==" ":
            numeropalabras+=1
    return numeropalabras
# def contarrcosas(cadena):
#     numeropalabras=0
#     for i in cadena:
#     return numeropalabras 
print(contartexto(cadena))