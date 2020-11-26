'''
Created on 25 Nov 2020

@author: estudiante
6.Realizar una función que busque una palabra escondida dentro de un texto. 
Por ejemplo, si la cadena es “shybaoxlna” y la palabra que queremos buscar es “hola”, 
entonces si se encontrará y deberá devolver True, en caso contrario deberá devolver False.
'''
busqueda="z"
cadena="shybaoxknah"
def buscador(cadena,busqueda):
    for i in busqueda:
        for i in cadena:
            if cadena[i]==busqueda[i]:
                return True
            