'''
Created on 29 nov. 2020

@author: fran

'''
#9.Crear una funcion que, tomando una cadena de texto como entrada, 
#construya y devuelva otra cadena formada de la siguiente manera:
#el metodo debe colocar todas las consonantes al principio y todas las vocales al final 
#de la misma, eliminando los blancos.Por ejemplo,
#pasandole la cadena "curso de programacion", 
#una posible solucion seria "crsdprgrmcnuoeoaaio
cadenavocales=[]
cadenaconsonantes=[]
cadenas="curso de programacion"
def cadenass (cadenas):
    cadenassinespacio=cadenas.replace(" ","")
    for i in range(0,len(cadenassinespacio)):
        if cadenassinespacio.lower()[i]=="a" or cadenassinespacio.lower()[i]=="e" or cadenassinespacio.lower()[i]=="i" or cadenassinespacio.lower()[i]=="i" or cadenassinespacio.lower()[i]=="o" or cadenassinespacio.lower()[i]=="u":
            cadenavocales.append(cadenas[i])
        else:
            cadenaconsonantes.append(cadenas[i])
    cadenasresultado=cadenaconsonantes+cadenavocales
    return cadenasresultado






print(cadenass(cadenas))