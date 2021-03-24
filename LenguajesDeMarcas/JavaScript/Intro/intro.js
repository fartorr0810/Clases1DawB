/* let numero = -4;
let palabra = "Hola mundo";
let respuesta = true;
const PI = 3.14;
numero = 54;
/*no se te peta, el javascript se cree que es una variable mas aunque no se lo digas.
 */
console.log(numero);
console.log(palabra);
console.log(respuesta);
console.log(PI);

/*
Declara 2 variables y asígnales los valores 5 y 2 respectivamente.

oMuestra por consola la sumade ambas variables.oMuestra por consola la restade ambas variables.
oMuestra por consola la multiplicaciónde ambas variables.oMuestra por consola la divisiónde ambas variables.
oMuestra por consola la módulode ambas variables.oDeclara una variable cuyo valor sea tu nombre.
oMuestra por consola el texto Holaconcatenado con el valor de la variable anterior.*/
let a = 5;
let b = 2;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
let nombree = "Francisco Arroyo De La Torre";
console.log("Hola concatenado " + nombree);
/*
Si declaramos una variable a=5 y utilizamos las siguientes instrucciones de incremento:
oconsole.log(a); oconsole.log(a++);oconsole.log(a);o¿qué se ha mostrado por consola?
oSi añadimos console.log(++a) ¿qué se mostraría en pantalla)
•Prueba las mismas instrucciones pero con el decremento
•Utiliza los operadores de asignación para sumar 3 a la variable a y muéstrala por consola.
 Al resultado obtenido réstale 3 y muéstralo por pantalla
 */
console.log(a);
console.log(a++);
console.log(a);
/*El valor se queda igual porque solo incrementa en el que se imprime, pero el valor de a seguira siendo el mismo
porque no se ha hecho ninguna asignacion*/
console.log(a);
console.log(a--);
console.log(a);
a += 3;
console.log(a);
/* Declara una variable cuyo nombre sea cadenay tenga el valor “Hola Mundo”.
•Muestra por consola la longitud de la cadena.
•Muestra por consola la cadena con todos sus caracteres en mayúsculas.
•Muestra por consola la cadena con todos sus caracteres en minúsculas.
•Muestra por consola la posición de la cadena en la que se encuentra la letra o.
•Muestra por consola la posición de la cadena en la que se encuentra la cadena “Hola”.
•Reemplaza la cadena “Mundo” por la cadena “Youtube” y muestra el resultado.
•Extrae la segunda parte de la cadena y muéstrala por consola.
•Comprueba si la cadena empieza por “h”.
•Comprueba si la cadena empieza por “H”.
•Muestra por consola la letra “r” 10 veces.
•Utilizando TEMPLATE STRINGS declara 3 variables con tu nombre, apellidos y edad y muéstralas por consola introduciéndolas dentro de una cadena. */
let cadena = "Hola mundo";
let mayuscula = cadena.toUpperCase;
let contador = 0;
console.log(cadena.length);
console.log(cadena.toUpperCase);
console.log(cadena.toLowerCase);
for (var i = 0; i < cadena.length; i++) {
    if (cadena[i] == 'o') {
        contador++
    }
}
console.log("Hay letra o:" + contador);
console.log(cadena.indexOf("Hola"));
console.log(cadena.replace("mundo", "Youtube"));
console.log(cadena.substring(5));
if (cadena[0] == "h") {
    console.log("Empieza por h");
} else if (cadena[0] == "H") {
    console.log("Empieza por H")
}
for (let i = 0; i < 10; i++) {
    console.log("r")
}
let nombre = "PACO";
let apellido = "PACO";
let edad = "20";
console.log("Hola " + nombre + " " + apellido + ". Tienes " + edad + " años.");


/* Genera un número aleatorio entre 0 y 100 redondeando y muéstralo por consola
•Muestra por consola el valor de PI.
•Genera un número aleatorio entre 5 y 10 redondeando y muéstralo por consola. 
Para este caso lo recomendado es utilizar la fórmula (Math.random()* (max-min)+min).
•Comprueba como funciona el método sign() para los siguientes valores: -5, 0, 5  */
let num = Math.random(0, 100) * 100;
console.log(Math.round(num));
console.log(Math.random(0, 100) * 100);
console.log(Math.sign(5));
console.log(Math.sign(-5));
console.log(Math.sign(0));
console.log(Math.PI);
/* EJERCICIO 1
•Declara una variable que se llame nume inicialízala a cero.
•Utilizando condicionales deberás comprobar si el valor de la variable numes mayor que cero, menor que cero
 o igual a cero. En cada uno de los casos deberás mostrar un mensaje utilizando TEMPLATE STRING 
 mostrando el valor de la variable nume indicando si es mayor, menor o igual a cero. */
let nume = 0;
if (nume == 0) {
    console.log("Es igual a 0")
} else if (nume > 0) {
    console.log("Es mayor a 0");
} else {
    console.log("Es menor a 0");
}
/* EJERCICIO 2
•Declara dos variables una con valor 5 y otra con valor 1.
•Utilizando operadores lógicos && o || utilizada el adecuado para mostrar el mensaje de que ambos valores
son mayores que cero. */
let num1 = 5;
let num2 = 1;
if (num1 > 0 && num2 > 0) {
    console.log("Los dos son mayores a 0")
} else if (num1 < 0 && num2 < 0) {
    console.log("Los dos son menores a 0")
} else if (num1 == 0 && num2 == 0) {
    console.log("Los dos son iguales a 0")
}
/* EJERCICIO 3
•Dada una cadena, se mostrará un mensaje en el caso de que tenga mas de 4 letras,
otro mensaje en el caso de que tenga menos de 4 letras y otro mensaje en el caso de tener 4 letras. */
let cadenaejer3 = prompt("Me metes una cadena");
if (cadena.length > 4) {
    console.log("Hay mas de 4 caracteres");
} else {
    console.log("Hay menos de 4 caracteres");
}
/* EJERCICIO 4
•Ordena 3 números de mayor a menor.
•Los números se introducirán por teclado. Para ello es necesario utilizar prompt para que pregunte los números.
•Muestra por consola los números ordenados de mayor a menor. */
numero1 = prompt("numero1");
numero2 = prompt("numero1");
numero3 = prompt("numero1");
if (numero1 > numero2) {
    if (numero1 > numero3) {
        if (numero2 > numero3) {
            console.log(numero1);
            console.log(numero2);
            console.log(numero3);
        }
    }
} else if (numero2 > numero1) {
    if (numero2 > numero3) {
        if (numero3 > numero1) {
            console.log(numero2);
            console.log(numero1);
            console.log(numero3);
        } else {
            console.log(numero2);
            console.log(numero3);
            console.log(numero1);
        }
    } else if (numero3 > numero1) {
        if (numero3 > numero1) {
            if (numero2 > numero1) {
                console.log(numero3);
                console.log(numero2);
                console.log(numero1);
            } else {
                console.log(numero3);
                console.log(numero1);
                console.log(numero2);
            }
        }
    }
}

/*EJERCICIO 5
•Modifica el ejercicio anterior para que muestre los resultados en lugar de por consola los 
pinte en la página html. Para ello puedes crear en el HTML, un elemento div para pintar los 
números introducidos y otro elemento div para pintar el resultado ordenado. Pista para este ejercicio:
 textContenty getElementById.*/
numerooo1 = prompt("numero1");
numerooo2 = prompt("numero1");
numerooo3 = prompt("numero1");
let text = document.getElementById(numero1, numero2, numero3).textContent;
document.getElementById(listaordenada);
if (numerooo1 > numerooo2) {
    if (numerooo1 > numerooo3) {
        if (numerooo2 > numerooo3) {
            console.log(numerooo1);
            console.log(numerooo2);
            console.log(numerooo3);
            document.write(numerooo1, numerooo2, numerooo3);

        }
    }
} else if (numerooo2 > numerooo1) {
    if (numerooo2 > numerooo3) {
        if (numerooo3 > numerooo1) {
            console.log(numerooo2);
            console.log(numerooo1);
            console.log(numerooo3);
            document.write(numerooo2, numerooo1, numerooo3);

        } else {
            console.log(numerooo2);
            console.log(numerooo3);
            console.log(numerooo1);
            document.write(numerooo2, numerooo3, numerooo1);

        }
    } else if (numerooo3 > numerooo1) {
        if (numerooo3 > numerooo1) {
            if (numerooo2 > numerooo1) {
                console.log(numerooo3);
                console.log(numerooo2);
                console.log(numerooo1);
                document.write(numerooo3, numerooo2, numerooo1);

            } else {
                console.log(numerooo3);
                console.log(numerooo1);
                console.log(numerooo2);
                document.write(numerooo3, numerooo1, numerooo2);

            }
        }
    }
}