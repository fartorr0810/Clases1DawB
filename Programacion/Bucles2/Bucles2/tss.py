def introduceunnumero (num):
    for i in range (2,num):
        if esprimo(i)==True:
            print("El numero",i,"es primo")
        else:
            print("No es primo el numero",i)
def esprimo(num):
    numdivisores=0 
    for i in range(2, num):
        if num%i==0:
            numdivisores+=1
        elif numdivisores==2:
            return True

print(introduceunnumero(num=int(input("Esto va a servir por mis huevos"))))