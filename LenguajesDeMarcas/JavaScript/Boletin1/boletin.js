/* 1 -Solicita un nombre, la edad y muestra por consola el mensaje 
"Hola  ____,  tienes  ____  años  y  el  año  que  viene  tendrás  ____ años"
Realiza el ejercicio con prompt(mensaje) y haz uso de los template strings. */
let nombre = prompt("Introduce tu nombre");
let edad = prompt("Introduce tu edad");
console.log(`Hola ${nombre} , tienes ${edad} años y el año que viene tendras.${edad+1}`);
//No comprendo porque NO SE SUMA AAAAAAAAAAAAA.


/* 2 -Escribe  un  programa  que  pueda  calcular  el  área  de  3  
figuras geométricas,  triángulo,  rectángulo  y  círculo.  
En  primer  lugar pregunta de qué figura se quiere calcular el área,
 después solicita los datos que necesites para calcularlo.
 triángulo = b * h/2
 rectángulo = b * h
 círculo = π * r2 (pi * radio al cuadrado) */
let eleccion = prompt("Que desea calcular Triangulo/Rectangulo/Circulo");
let area;
if (eleccion == "Circulo") {
    let radio = prompt("Dime el radio");
    area = Math.PI * Math.pow(radio, 2);
    console.log(area)
} else if (eleccion == "Triangulo") {
    let b = prompt("Dime la base");
    let h = prompt("Dime la altura")
    area = b * h / 2;
    console.log(area);

} else if (eleccion == "Rectangulo") {
    let b = prompt("Dime la base");
    let h = prompt("Dime la altura");
    area = b * h;
    console.log(area);
} else {
    console.log("No existe esa opcion");
}
/* 3 -Solicita  un  número  e  imprime  todos  los  números  pares  e 
impares desde 1 hasta ese número con el mensaje "es par" o "es impar"si el 
número es 5 el resultado será:
1 -es impar
2 -es par
3 -es impar
4 -es par
5 -es impar */
num = prompt("Introduce un numero");
for (let i = 0; i < num; i++) {
    if (i % 2 == 0) {
        console.log(i + "Es par");
    } else {
        console.log(i + "Es impar");
    }
}
/* 4 -Escribe un programa que pida un número entero mayor que 1 
y que escriba si el número es primo o no.Un número primo es aquel
 que solo es divisible por sí mismo y la unidad */
let numeru = prompt("Introduce un numero mayor a 1");
if (numeru % num)