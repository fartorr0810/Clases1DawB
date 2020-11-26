'''
Created on 26 nov. 2020

@author: fran
'''
cadena="shy"
busqueda="hola"
def buscadorr(cadena):
    contadorbusqueda=0
    contadorcadena=0
    while contadorbusqueda<len(busqueda) and contadorcadena<len(cadena):
        letracadena=len(cadena)
        letrabusqueda=len(busqueda)
        if letrabusqueda==letracadena:
            contadorbusqueda+=1
            contadorcadena+=1
        else:
            contadorcadena+=1
    if contadorcadena==len(cadena):
        return True
print(buscadorr(cadena))
# def buscador(cadena):
#     resultado=""
#     i=1
#     j=1
#     while busqueda!=resultado:
#         if cadena[i]==busqueda[j]:
#             i+=1
#             j+=1
#             resultado=+j
#         else:
#             i+=1
#     return True
# print(buscador(cadena))