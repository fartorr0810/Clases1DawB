/* pedir un numero entre 1 y 10 s es de 1 hasta 4 - suspenso
si es 5 aprobado
6 bien
7 y 8 notable
9 y 10 sobresaliente
 */
let nota = prompt("numero1");
nota = parseInt(nota);
switch (nota) {
    case 1:
    case 2:
    case 3:
    case 4:
        console.log("Suspenso");
        break;
    case 5:
        console.log("Suficiente");
        break;
    case 6:
        console.log("Bien");
        break;
    case 7:
    case 8:

        console.log("Notable");
        break;
    case 9:
    case 10:
        console.log("Sobresaliente");
        break;
    default:
        break;
}

let edad = prompt("Me metes la edad bb");
edad = parseInt(edad);

switch (!false) {
    case edad <= 12:
        console.log("Es un ninio");
        break;
    case edad < 18:
        console.log("Es un adolescente");
        break;
    case edad = 18:
        console.log("Es mayor de edad");
        break;

    case edad <= 35:
        console.log("Es joven");
        break;
    case edad > 35:
        console.log("Es alduto")
    case edad > 65:
        console.log("Sos tutankamon");
    default:
        break;
}

let num = 1;
let paro = (num % 2 == 0) ? "Es par" : "No es par";
console.log(paro);