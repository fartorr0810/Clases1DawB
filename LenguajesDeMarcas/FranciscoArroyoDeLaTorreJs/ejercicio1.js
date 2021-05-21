/* 1.Realiza un script de javascript que genere un entero aleatorio entre 0 y 100 y 
que vaya preguntando al usuario mediante prompt al usuario el número, indicándole en
cada ocasión si el número es mayor que tiene que adivinar es mayor o menor que el introducido, 
en caso de que sea correcto le dará la enhorabuena indicando el número correcto. Generar número 
aleatorio entre 0 y 10 → Math.floor(Math.random() * 10) */
let solucion = Math.floor(Math.random() * 101);
let num = -1;
do {
    num = prompt("Introduce el numero que creas correcto");
    if (num > solucion) {
        alert("El numero es menor");
    } else if (num < solucion) {
        alert("El numero es mayor")
    } else if (num == solucion) {
        alert("Enhorabuena, has acertado , ahora vamos a por el siguiente");
    }
} while (num != solucion)