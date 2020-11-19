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
        return eurtolib(eur=eurtolib(eur=int(input("Introduce los euros a convertir"))))
    elif eleccion==4:
        return dolartoeur(dol=libtoeur(dol=int(input("Introduce los euros a convertir"))))
    elif eleccion==5:
        return libtodol(lib=libtodol(dol=int(input("Introduce los dolares a convertir"))))
    elif eleccion==6:
        return doltolib(dol=doltolib(dol=int(input("Introduce los dolares a convertir"))))
    

def eurtodolar (eur):
    dolar=eur*1.19
    return dolar
def dolartoeur(dol):
    eur=dol*0.89
    return eur
def eurtolib(eur):
    lib=eur*0.89
    return lib
def libtoeur(lib):
    eur=lib*1.12
    return eur
def libtodol(lib):
    dol=lib*1.33
    return dol
def doltolib(dol):
    lib=dol*0.75
    return lib
print(menu())

