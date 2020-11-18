'''
Created on 18 Nov 2020

@author: xXxArroyoxXx
'''
'''
4.Diseñar un programa que muestre un menu con las siguientes opciones:
    1.Cambio de euros a dolares
    2.Cambio de dólares a euros
    3.Cambio de euros a libras
    4.Cambio de libras a euros.
    5.Cambio de libras a dolares
    6.Cambio de dolares a libras
    7.Salir
'''
def menu():
    eleccion=10
    while eleccion>7 or eleccion<0:
        eleccion=int(input(''' 1.Cambio de euros a dolares
        2.Cambio de dólares a euros
        3.Cambio de euros a libras
        4.Cambio de libras a euros.
        5.Cambio de libras a dolares
        6.Cambio de dolares a libras
        7.Salir
        '''))
    if eleccion==1:
        return eurtodolar(eur=eurtodolar(eur=int(input("Introduce los euros a convertir"))))
    elif eleccion==2:
        return dolartoeur(dol=dolartoeur(dol=int(input("Introduce los dolares a convertir"))))
    elif eleccion==3:
        return eurtolib(eur=eurtolib(eur=int(input("Introduce los dolares a convertir"))))
    elif eleccion==4:
        return dolartoeur(dol=dolartoeur(dol=int(input("Introduce los dolares a convertir"))))
    elif eleccion==5:
        return dolartoeur(dol=dolartoeur(dol=int(input("Introduce los dolares a convertir"))))
    elif eleccion==6:
        return dolartoeur(dol=dolartoeur(dol=int(input("Introduce los dolares a convertir"))))

def eurtodolar (eur):
    dolar=eur*1.19
    return dolar
def dolartoeur(dol):
    eur=dol*0.945
    return eur
def eurtolib(eur):
    return 1
def libtoeur(lib):
    return 1
def libtodol(lib):
    return 1
def doltolib(dol):
    return 1
print(menu())