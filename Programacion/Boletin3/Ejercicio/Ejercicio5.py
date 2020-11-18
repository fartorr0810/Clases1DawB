'''
Created on 18 nov. 2020

@author: fran
'''
'''
5.Realizar un programa que solicite la coordenada x e y de un punto 
e informe si se encuentre en el primer, segundo, tercer o cuarto cuadrante.
'''

def calculo():
    x=int(input("Introduce las cordenadas en X"))
    y=int(input("Introduce las cordenadas en Y"))
    if (x>0) and (y>0):
        print("Punto en el primer cuadrante")
    elif (x>0) and (y<0):
        print("Punto en el primer cuadrante")
    elif (x<0) and (y<0):
        print("Punto en el primer cuadrante")
    elif (x<0) and (y>0):
        print("Punto en el primer cuadrante")
    else:
        print("Estas en el punto de origen")    

print(calculo())