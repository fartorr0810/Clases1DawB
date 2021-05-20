/* 1.Crear  una  función  que  calcule  la  media  aritmética 
 de  cinco  valores  que  se  le  pasan  como argumentos.  */
function ejercicio1(num1, num2, num3, num4, num5) {
    return (num1 + num2 + num3 + num4 + num5) / 5;
}
/* 2.Crea una función que acepta las notas de los tres trimestres de un alumno.
Devolverá “aprobado” o “suspenso” en función de si el promedio de las notas es
igual o superior a 5 o no lo es. A continuación de ello, se mostrará cuándo fue
 modificado por última vez el documento actual.
 */
function ejercicio2(trimestre1, trimestre2, trimestre3) {
    let media = (trimestre1 + trimestre2 + trimestre3) / 3;
    let mensaje = "";
    if (media => 5) {
        mensaje = "Aprobado";
    } else {
        mensaje = "Suspenso";
    }
    let fecha = new Date();
    document.write(fecha.getDate() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getFullYear());
    return mensaje;
}
/* 3.Crea un array de 15 elementos numéricos que el usuario irá introduciendo.
 Al final, se tiene que mostrar qué número es el menor y en qué posición o 
 posiciones del array está (no olvides que en el array la primera posición es la 0) */
function ejercicio3() {
    let lista = [];
    let menor = -999999999;
    for (let index = 0; index < 15; index++) {
        let num = prompt("Introduce un numero");
        lista.push(num);
        if (num < menor) {
            menor = num;
        }
    }
    for (let index = 0; index < lista.length; index++) {
        let posicion = -999999999;
        if (lista[i] = menor) {
            posicion = i;
        }
    }
    return console.log("La posicion del menor numero es: " + i);
}
/* 4.Crea un script que tome una serie de palabras ingresadas por el usuario y
almacene esas palabras en un array. Posteriormente, manipula ese array para mostrar 
una nueva ventana con los siguientes datos: 
La primera palabra ingresada por el usuario. 
La última palabra ingresada por el usuario.  
El número de palabras presentes en el array. 
Todas las palabras ordenadas alfabéticamente.   */
function ejercicio4() {
    let eleccion = "";
    let lista=[];
    let continuar = true;
    do {
        let palabra = prompt("Introduce la palabra que desee");

    } while (continuar != true);
}